#Spring cloud 项目
#部署说明

1. 配置 MySQL
   #1.1 安装 MySQL（可选）
   友情提示：安装 MySQL 是可选步骤，也可以购买 MySQL 云服务。

① 执行如下命令，进行 MySQL 的安装。

## ① 安装 MySQL 5.7 版本的软件源 https://dev.mysql.com/downloads/repo/yum/
rpm -Uvh https://dev.mysql.com/get/mysql57-community-release-el7-11.noarch.rpm

## ② 安装 MySQL Server 5.7 版本
yum install mysql-server --nogpgcheck

## ③ 查看 MySQL 的安装版本。结果是 mysqld  Ver 5.7.37 for Linux on x86_64 (MySQL Community Server (GPL))
mysqld --version
② 修改 /etc/my.cnf 文件，在文末加上 lower_case_table_names=1 和 validate_password=off 配置，执行 systemctl restart mysqld 命令重启。

③ 执行 grep password /var/log/mysqld.log 命令，获得 MySQL 临时密码。

2022-04-16T09:39:57.365086Z 1 [Note] A temporary password is generated for root@localhost: ZOKUaehW2e.e
④ 执行如下命令，修改 MySQL 的密码，设置允许远程连接。

## ① 连接 MySQL Server 服务，并输入临时密码
mysql -uroot -p

## ② 修改密码，123456 可改成你想要的密码
alter user 'root'@'localhost' identified by '123456';

## ③ 设置允许远程连接
use mysql;
update user set host = '%' where user = 'root';
FLUSH PRIVILEGES;
#1.2 导入 SQL 脚本
创建一个名字为 ruoyi-vue-pro 数据库，执行数据库对应的 sql (opens new window)目录下的 SQL 文件，进行初始化。

使用 Navicat 导入 SQL 脚本

#2. 配置 Redis
友情提示：安装 Redis 是可选步骤，也可以购买 Redis 云服务。

执行如下命令，进行 Redis 的安装。

## ① 安装 remi 软件源
yum install http://rpms.famillecollet.com/enterprise/remi-release-7.rpm

## ② 安装最新 Redis 版本。如果想要安装指定版本，可使用 yum --enablerepo=remi install redis-6.0.6 -y 命令
yum --enablerepo=remi install redis

## ③ 查看 Redis 的安装版本。结果是 Redis server v=6.2.6 sha=00000000:0 malloc=jemalloc-5.1.0 bits=64 build=4ab9a06393930489
redis-server --version

## ④ 启动 Redis 服务
systemctl restart redis
端口是 6379，密码未设置
#3. 部署后端
#3.1 修改配置
后端 dev 开发环境对应的是 application-dev.yaml (opens new window)配置文件，主要是修改 MySQL 和 Redis 为你的地址。如下图所示：

配置文件

#3.2 编译后端
在项目的根目录下，执行 mvn clean package -Dmaven.test.skip=true 命令，编译后端项目，构建出它的 Jar 包。如下图所示：

编译后端

疑问：-Dmaven.test.skip=true 是什么意思？

跳过单元测试的执行。如果你项目的单元测试写的不错，建议使用 mvn clean package 命令，执行单元测试，保证交付的质量。

#3.3 上传 Jar 包
在 Linux 服务器上创建 /work/projects/cloud-server 目录，使用 scp 命令或者 FTP 工具，将 cloud-server.jar 上传到该目录下。如下图所示：

上传 Jar 包


#3.4 编写脚本
在 /work/projects/cloud-server 目录下，新建 Shell 脚本 deploy.sh，用于启动后端项目。编写内容如下：

#!/bin/bash
set -e

DATE=$(date +%Y%m%d%H%M)
# 基础路径
BASE_PATH=/work/projects/cloud-server
# 服务名称。同时约定部署服务的 jar 包名字也为它。
SERVER_NAME=cloud-server
# 环境
PROFILES_ACTIVE=dev

# heapError 存放路径
HEAP_ERROR_PATH=$BASE_PATH/heapError
# JVM 参数
JAVA_OPS="-Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$HEAP_ERROR_PATH"

# SkyWalking Agent 配置
#export SW_AGENT_NAME=$SERVER_NAME
#export SW_AGENT_COLLECTOR_BACKEND_SERVICES=192.168.0.84:11800
#export SW_GRPC_LOG_SERVER_HOST=192.168.0.84
#export SW_AGENT_TRACE_IGNORE_PATH="Redisson/PING,/actuator/**,/admin/**"
#export JAVA_AGENT=-javaagent:/work/skywalking/apache-skywalking-apm-bin/agent/skywalking-agent.jar

# 停止：优雅关闭之前已经启动的服务
function stop() {
echo "[stop] 开始停止 $BASE_PATH/$SERVER_NAME"
PID=$(ps -ef | grep $BASE_PATH/$SERVER_NAME | grep -v "grep" | awk '{print $2}')
# 如果 Java 服务启动中，则进行关闭
if [ -n "$PID" ]; then
# 正常关闭
echo "[stop] $BASE_PATH/$SERVER_NAME 运行中，开始 kill [$PID]"
kill -15 $PID
# 等待最大 120 秒，直到关闭完成。
for ((i = 0; i < 120; i++))
do
sleep 1
PID=$(ps -ef | grep $BASE_PATH/$SERVER_NAME | grep -v "grep" | awk '{print $2}')
if [ -n "$PID" ]; then
echo -e ".\c"
else
echo '[stop] 停止 $BASE_PATH/$SERVER_NAME 成功'
break
fi
done

        # 如果正常关闭失败，那么进行强制 kill -9 进行关闭
        if [ -n "$PID" ]; then
            echo "[stop] $BASE_PATH/$SERVER_NAME 失败，强制 kill -9 $PID"
            kill -9 $PID
        fi
    # 如果 Java 服务未启动，则无需关闭
    else
        echo "[stop] $BASE_PATH/$SERVER_NAME 未启动，无需停止"
    fi
}

# 启动：启动后端项目
function start() {
# 开启启动前，打印启动参数
echo "[start] 开始启动 $BASE_PATH/$SERVER_NAME"
echo "[start] JAVA_OPS: $JAVA_OPS"
echo "[start] JAVA_AGENT: $JAVA_AGENT"
echo "[start] PROFILES: $PROFILES_ACTIVE"

    # 开始启动
    nohup java -server $JAVA_OPS $JAVA_AGENT -jar $BASE_PATH/$SERVER_NAME.jar --spring.profiles.active=$PROFILES_ACTIVE > nohup.out 2>&1 &
    echo "[start] 启动 $BASE_PATH/$SERVER_NAME 完成"
}

# 部署
function deploy() {
cd $BASE_PATH
# 第一步：停止 Java 服务
stop
# 第二步：启动 Java 服务
start
}

#3.5 启动后端
① 【可选】执行 yum install -y java-1.8.0-openjdk 命令，安装 OpenJDK 8。

友情提示：如果已经安装 JDK，可不安装。建议使用的 JDK 版本为 8、11、17 这三个。

② 执行 sh deploy.sh 命令，启动后端项目。日志如下：

[stop] 开始停止 /work/projects/cloud-server/cloud-server
[stop] /work/projects/cloud-server/cloud-server 未启动，无需停止
[start] 开始启动 /work/projects/cloud-server/cloud-server
[start] JAVA_OPS: -Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/work/projects/cloud-server/heapError
[start] JAVA_AGENT:
[start] PROFILES: dev
[start] 启动 /work/projects/cloud-server/cloud-server 完成
③ 执行 tail -f nohup.out 命令，查看启动日志。看到如下内容，说明启动完成：

2022-04-13 00:06:20.049  INFO 1395 --- [main] [TID: N/A] c.i.cloud.server.cloudServerApplication  : Started cloudServerApplication in 35.315 seconds (JVM running for 36.282)
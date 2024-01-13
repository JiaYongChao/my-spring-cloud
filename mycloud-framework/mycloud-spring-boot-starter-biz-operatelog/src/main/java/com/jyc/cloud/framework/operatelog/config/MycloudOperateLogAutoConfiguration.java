package com.jyc.cloud.framework.operatelog.config;

import com.jyc.cloud.framework.operatelog.core.aop.OperateLogAspect;
import com.jyc.cloud.framework.operatelog.core.service.OperateLogFrameworkService;
import com.jyc.cloud.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.jyc.cloud.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MycloudOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}

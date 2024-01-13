package com.jyc.cloud.framework.mq.redis.config;

import com.jyc.cloud.framework.mq.redis.core.RedisMQTemplate;
import com.jyc.cloud.framework.mq.redis.core.interceptor.RedisMessageInterceptor;
import com.jyc.cloud.framework.redis.config.MycloudRedisAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * Redis 消息队列 Producer 配置类
 *
 * @author JiaYongChao
 */
@Slf4j
@AutoConfiguration(after = MycloudRedisAutoConfiguration.class)
public class MycloudRedisMQProducerAutoConfiguration {

    @Bean
    public RedisMQTemplate redisMQTemplate(StringRedisTemplate redisTemplate,
                                           List<RedisMessageInterceptor> interceptors) {
        RedisMQTemplate redisMQTemplate = new RedisMQTemplate(redisTemplate);
        // 添加拦截器
        interceptors.forEach(redisMQTemplate::addInterceptor);
        return redisMQTemplate;
    }

}

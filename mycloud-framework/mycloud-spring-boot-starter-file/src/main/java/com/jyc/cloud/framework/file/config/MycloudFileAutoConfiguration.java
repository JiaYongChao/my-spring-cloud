package com.jyc.cloud.framework.file.config;

import com.jyc.cloud.framework.file.core.client.FileClientFactory;
import com.jyc.cloud.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author JiaYongChao
 */
@AutoConfiguration
public class MycloudFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}

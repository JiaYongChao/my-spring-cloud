package com.jyc.cloud.framework.env.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 环境配置
 *
 * @author JiaYongChao
 */
@ConfigurationProperties(prefix = "mycloud.env")
@Data
public class EnvProperties {

    public static final String TAG_KEY = "mycloud.env.tag";

    /**
     * 环境标签
     */
    private String tag;

}

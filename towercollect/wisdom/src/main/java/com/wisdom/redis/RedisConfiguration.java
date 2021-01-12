package com.wisdom.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : RedisConfiguration
 * @Description : redis配置
 * @Author : dingwei
 * @Date: 2021-01-08 16:47
 */
@Configuration
public class RedisConfiguration {

    @Bean(initMethod = "initialPool")
    @ConfigurationProperties(prefix = "spring.mredis")
    public RedisUtil redis(){
        return new RedisUtil();
    }
}

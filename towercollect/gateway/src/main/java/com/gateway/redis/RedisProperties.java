package com.gateway.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : RedisProperties
 * @Description : redis配置
 * @Author : dingwei
 * @Date: 2021-01-08 16:47
 */
@Component
public class RedisProperties {

    @Value("${spring.redis.ip}")
    private String ip;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.timeout}")
    private String timeOut;
    @Value("${spring.redis.password}")
    private String passWord;
    @Value("${spring.redis.maxactive}")
    private String  maxActive;
    @Value("${spring.redis.maxidle}")
    private String maxidle;
    @Value("${spring.redis.maxwait}")
    private String maxWait;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public String getMaxidle() {
        return maxidle;
    }

    public void setMaxidle(String maxidle) {
        this.maxidle = maxidle;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }
}

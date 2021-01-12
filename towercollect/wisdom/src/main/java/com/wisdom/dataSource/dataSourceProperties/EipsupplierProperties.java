package com.wisdom.dataSource.dataSourceProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : EipsupplierProperties
 * @Description : 数据库连接配置
 * @Author : dingwei
 * @Date: 2021-01-06 16:00
 */
@Component
public class EipsupplierProperties {
    @Value("${spring.dataSource.eipsupplier.url}")
    private String url;
    @Value("${spring.dataSource.eipsupplier.username}")
    private String username;
    @Value("${spring.dataSource.eipsupplier.password}")
    private String password;
    @Value("${spring.dataSource.eipsupplier.driverClassName}")
    private String driverClassName;
    @Value("${spring.dataSource.eipsupplier.initialSize}")
    private int initialSize;
    @Value("${spring.dataSource.eipsupplier.minIdle}")
    private int minIdle;
    @Value("${spring.dataSource.eipsupplier.maxIdle}")
    private int maxIdle;
    @Value("${spring.dataSource.eipsupplier.maxActive}")
    private int maxActive;
    @Value("${spring.dataSource.eipsupplier.maxWait}")
    private int maxWait;
    @Value("${spring.dataSource.eipsupplier.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.dataSource.eipsupplier.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.dataSource.eipsupplier.validationQuery}")
    private String validationQuery;
    @Value("${spring.dataSource.eipsupplier.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.dataSource.eipsupplier.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${spring.dataSource.eipsupplier.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${spring.dataSource.eipsupplier.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${spring.dataSource.eipsupplier.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    @Value("${spring.dataSource.eipsupplier.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.dataSource.eipsupplier.breakAfterAcquireFailure}")
    private Boolean breakAfterAcquireFailure;
    @Value("${spring.dataSource.eipsupplier.connectionErrorRetryAttempts}")
    private int connectionErrorRetryAttempts;

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxOpenPreparedStatements() {
        return maxOpenPreparedStatements;
    }

    public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
        this.maxOpenPreparedStatements = maxOpenPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public Boolean getBreakAfterAcquireFailure() {
        return breakAfterAcquireFailure;
    }

    public void setBreakAfterAcquireFailure(Boolean breakAfterAcquireFailure) {
        this.breakAfterAcquireFailure = breakAfterAcquireFailure;
    }

    public int getConnectionErrorRetryAttempts() {
        return connectionErrorRetryAttempts;
    }

    public void setConnectionErrorRetryAttempts(int connectionErrorRetryAttempts) {
        this.connectionErrorRetryAttempts = connectionErrorRetryAttempts;
    }
}

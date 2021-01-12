package com.wisdom.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.wisdom.dataSource.dataSourceProperties.EipsupplierProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : DataSourceConfiguration
 * @Description : 数据库连接配置
 * @Author : dingwei
 * @Date: 2021-01-06 16:00
 */
@Configuration
public class DataSourceConfiguration {

    @Autowired
    EipsupplierProperties eipsupplierProperties;

    public DataSource eipsupplier(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(eipsupplierProperties.getUrl());
        datasource.setUsername(eipsupplierProperties.getUsername());
        datasource.setPassword(eipsupplierProperties.getPassword());
        datasource.setDriverClassName(eipsupplierProperties.getDriverClassName());
        datasource.setInitialSize(eipsupplierProperties.getInitialSize());
        datasource.setMinIdle(eipsupplierProperties.getMinIdle());
        datasource.setMaxActive(eipsupplierProperties.getMaxActive());
        datasource.setMaxWait(eipsupplierProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(eipsupplierProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(eipsupplierProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(eipsupplierProperties.getValidationQuery());
        datasource.setTestWhileIdle(eipsupplierProperties.getTestWhileIdle());
        datasource.setTestOnBorrow(eipsupplierProperties.getTestOnBorrow());
        datasource.setTestOnReturn(eipsupplierProperties.getTestOnReturn());
        datasource.setPoolPreparedStatements(eipsupplierProperties.getPoolPreparedStatements());
        datasource.setMaxOpenPreparedStatements(eipsupplierProperties.getMaxOpenPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(eipsupplierProperties.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setBreakAfterAcquireFailure(eipsupplierProperties.getBreakAfterAcquireFailure());
        datasource.setConnectionErrorRetryAttempts(eipsupplierProperties.getConnectionErrorRetryAttempts());
        return datasource;
    }

    @Primary
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(eipsupplier());
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("eipsupplier",eipsupplier());
        dataSource.setTargetDataSources(dsMap);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}

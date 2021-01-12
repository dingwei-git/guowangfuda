package com.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Gateway的路由配置
 * @author: dingwei
 * @create: 2021-01-12 10:07
 */
@Configuration
public class ApiLocator {

    @Autowired
    private AuthorizationFilter authorizationFilter;
    @Value("${spring.route.wisdom.id}")
    String wisdomId;
    @Value("${spring.route.wisdom.url}")
    String wisdomUrl;
    @Value("${spring.route.wisdom.intercept}")
    String wisdomIntercept;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(wisdomId,r -> r.path(wisdomIntercept)
                                .filters(f -> f.stripPrefix(2).filter(authorizationFilter))
                                .uri(wisdomUrl)
                ).build();
    }

}

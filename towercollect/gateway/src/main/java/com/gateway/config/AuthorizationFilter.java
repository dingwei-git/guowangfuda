package com.gateway.config;

import com.gateway.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName : AuthorizationFilter
 * @Description : 全局token校验
 * @Author : dingwei
 * @Date: 2021-01-12 10:07
 */

@Component
public class AuthorizationFilter implements GatewayFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Autowired
    RedisUtil redis;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("request.getURI().getPort()===="+request.getURI().getPort());
        log.info("request.getURI().getPath()===="+request.getURI().getPath());

        if(request.getURI().getPath().equals("/api/wisdom/image/getImage")){
            return  chain.filter(exchange);
        }
        String authorization = request.getHeaders().getFirst("Authorization");
        String token = redis.getString("token");
        if (StringUtils.isEmpty(authorization)||!authorization.equals(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        try {
//            String token = authorization.split(" ")[1];
//            Map<String, String> tokenFromRedis = JwtTokenManager.getTokenFromRedis(redisUtil, securityKey, token);
//            if (tokenFromRedis == null) {
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            }
            ServerHttpRequest build = request.mutate().header("token", token).build();
            return chain.filter(exchange.mutate().request(build).build());
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }

}

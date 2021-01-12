package com.gateway.anantation;

import com.gateway.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(RedisConfiguration.class)
public @interface EnableRedis {
}

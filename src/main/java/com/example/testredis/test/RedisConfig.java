package com.example.testredis.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * description
 *
 * @author erpang
 * date 2021/9/3 12:48
 */
/*@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> stringObjectRedisTemplate = new RedisTemplate<>();
        stringObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringObjectRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        stringObjectRedisTemplate.setConnectionFactory(factory);
        return stringObjectRedisTemplate;
    }
}*/

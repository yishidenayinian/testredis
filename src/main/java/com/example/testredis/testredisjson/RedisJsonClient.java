package com.example.testredis.testredisjson;

import com.example.testredis.testredisjson.utils.JReJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;


/**
 * @author erpang
 * @PackageName: com.example.testredis.testredisjson
 * @ClassName: RedisJsonClient
 * @Description:
 * @date 2022/4/28 14:02
 */
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource(value = "application.properties")
@Configuration
@EnableCaching
public class RedisJsonClient extends CachingConfigurerSupport {
    @Value("${spring.redis.host:127.0.0.1}")
    private String host;
    @Value("${spring.redis.port:6379}")
    public int port;

    public RedisJsonClient() {
    }

    @Bean
    public JReJSON jReJSONFactory() {
        return new JReJSON(host, port);
    }

    @Bean
    public Jedis JedisFactory() {
        return new Jedis(host, port);
    }

    public JReJSON getReJSON() {
        return new JReJSON("47.104.191.239",62369);
    }
}

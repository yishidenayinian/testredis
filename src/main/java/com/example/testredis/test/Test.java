package com.example.testredis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;

/**
 * description
 *
 * @author erpang
 * date 2021/9/3 12:46
 */
/*
@Component
public class Test {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void test() {
        Person p = new Person();
        p.setName("liuzhijian");
        redisTemplate.opsForValue().set("tttt", p);
        LinkedHashMap lhm = (LinkedHashMap) redisTemplate.opsForValue().get("tttt");
        lhm.forEach((k, v) -> {
            System.out.println(k + "::" + v);
        });
    }
}
*/

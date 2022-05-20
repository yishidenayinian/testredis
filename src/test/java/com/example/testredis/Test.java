package com.example.testredis;


import com.alibaba.fastjson.JSON;
import com.example.testredis.testCurdRepository.pojo.User;
import com.example.testredis.testredisjson.utils.JReJSON;
import com.example.testredis.testredisjson.utils.Path;
import redis.clients.jedis.Jedis;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author erpang
 * @PackageName: com.example.testredis
 * @ClassName: Test
 * @Description:
 * @date 2022/4/26 20:18
 */
public class Test {
    private String host = "47.104.191.239";
    private int port = 62379;
    Jedis jedis = new Jedis(host,port);
    JReJSON reJSON = new JReJSON(host,port);

    @org.junit.jupiter.api.Test
    public void test() {
        // 清空当前库
        jedis.flushDB();

        reJSON.set("test", "test1");
        // 默认根路径 .
        assertEquals("test1", reJSON.get("test"));

        reJSON.set("obj", new Object());
        reJSON.set("obj", null, new Path(".test"));
        reJSON.set("obj", "qweqe", new Path(".test1"));
        Path p = new Path(".heihie");
        User u = new User();
        u.setName("dada");
        u.setAge(11);
        reJSON.set("obj", u, p);
        Object obj = reJSON.get("obj");
        System.out.println(JSON.toJSONString(obj));

        reJSON.del("obj", p);

        obj = reJSON.get("obj");
        System.out.println(JSON.toJSONString(obj));

        reJSON.del("obj");

        obj = reJSON.get("obj");
        System.out.println(JSON.toJSONString(obj));


        reJSON.set("user:redisjson",u);
    }
}

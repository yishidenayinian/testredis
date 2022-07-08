package com.example.testredis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.testredis.testCurdRepository.pojo.User;
import com.example.testredis.testredisjson.RedisJsonClient;
import com.example.testredis.testredisjson.utils.JReJSON;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.ObjectUtils;
import org.springframework.util.comparator.NullSafeComparator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author erpang
 * @PackageName: com.example.testredis
 * @ClassName: TT
 * @Description:
 * @date 2022/4/28 14:25
 */
public class TT {

/*    @Test
    public void tt() {
        RedisJsonClient r = new RedisJsonClient();
        JReJSON reJSON = r.getReJSON();
        User u = User.builder().name("my name11 is reclient").build();
        reJSON.set("reclient",u);
        Object reclient = reJSON.get("reclient");
        Gson g = new Gson();
        User user = g.fromJson(g.toJson(reclient), u.getClass());
        System.out.println(g.toJson(user) );
    }


    public static void main(String[] args) {
        Map<String, String> m = new HashMap();
        m.put("name","lll");
        m.put("sex","man");
        m.put("age","11");

        //m.entrySet().stream().filter(o->!ObjectUtils.isEmpty(o.getValue())).collect()
        Map<String, byte[]> da = new LinkedHashMap<>();
        m.forEach((k,v) -> {
            if (!ObjectUtils.isEmpty(v)) {
                try {
                    da.put(k,v.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });




       *//* String s = new String(source.bucket.data.get("objectValue"),"UTF-8");
        Map<String,String> map1 = JSON.parseObject(s,Map.class);
        Jackson2JsonRedisSerializer j2r = new Jackson2JsonRedisSerializer(type);
        Map<String, Object> c = map1.entrySet().stream().filter(o->!ObjectUtils.isEmpty(o.getValue())). collect(Collectors.toMap(
                k-> k,
                v->v
        ));*//*
    }*/
}

package com.example.testredis.testCurdRepository.util;

import com.alibaba.fastjson.JSON;
import com.example.testredis.testCurdRepository.pojo.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository.util
 * @ClassName: GetPro
 * @Description:
 * @date 2022/4/28 13:29
 */
public class GetPro {
    public static String getProperties(Object object) {
        StringJoiner str = new StringJoiner(":");
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (!ObjectUtils.isEmpty(clazz)) {
            RedisHash redisHashAnno = (RedisHash) clazz.getAnnotation(RedisHash.class);
            if (!ObjectUtils.isEmpty(redisHashAnno)) {
                str.add(ObjectUtils.isEmpty(redisHashAnno.value())? clazz.getName() : redisHashAnno.value());
            }

            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Set<String> fieldNames = new HashSet<>(fieldList.size() * 2);
        if (ObjectUtils.isEmpty(fieldList)) {
            return clazz.getName();
        }
        fieldList.forEach(field -> {
            Id annotation = field.getAnnotation(Id.class);
            if (!ObjectUtils.isEmpty(annotation)) {
                String name = field.getName();
                Map map = JSON.parseObject(JSON.toJSONString(object),Map.class);
                String idVal = String.valueOf(map.get(name));
                str.add(idVal);
            }
        });
        return str.toString();
    }

}


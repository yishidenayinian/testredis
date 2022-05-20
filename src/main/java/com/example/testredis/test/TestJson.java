package com.example.testredis.test;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author erpang
 * @PackageName: com.example.testredis.test
 * @ClassName: TestJson
 * @Description:
 * @date 2021/12/8 14:55
 */
/*@RestController
public class TestJson {
    @PostMapping(value="/test",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object test1() {
        System.out.println("+++++++++++++++++++++");
        Map map = new HashMap();
        map.put("a",123);
        map.put("b",234);
        return map;
    }
}*/

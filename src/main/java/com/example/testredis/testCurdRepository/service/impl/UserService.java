package com.example.testredis.testCurdRepository.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.testredis.testCurdRepository.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository.service
 * @ClassName: UserService
 * @Description:
 * @date 2022/4/27 10:26
 */

@Component
public class UserService {

    public String aa(User u) {
        return JSON.toJSONString(u);
    }
}

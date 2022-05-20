package com.example.testredis.testCurdRepository;


import com.alibaba.fastjson.JSON;
import com.example.testredis.testCurdRepository.pojo.People;
import com.example.testredis.testCurdRepository.pojo.User;
import com.example.testredis.testCurdRepository.service.TestRedis;
import com.example.testredis.testCurdRepository.service.TestUser;
import com.example.testredis.testCurdRepository.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;


/**
 * @author erpang
 * @PackageName: com.example.testredis.testuserRepository
 * @ClassName: RequestController
 * @Description:
 * @date 2022/4/26 17:35
 */
@RestController
public class RequestController {

    @Autowired
    private TestRedis crud;

    @Autowired
    private TestUser crud1;

    @Autowired
    private UserService us;

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test(@RequestBody User u) {
        System.out.println("接受参数 " + JSON.toJSONString(u));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1311111111");
        strings.add("1511111111");
        u.setPhones(strings);


        crud1.save(u);

        Optional<User> opt = crud1.findById("lzj");
        User user = null;
        if (opt.isPresent()) {
            user = opt.get();
        }
        System.out.println(JSON.toJSONString(user));
        if (Math.random()<0.5) {
            crud1.deleteById("lzj");
        } else {
            crud1.delete(user);
        }

        System.out.println("删除完毕");
        return "----------";
    }


    @PostMapping(value = "/test1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test1() {

        User u = new User();
        u.setName("test1");
        u.setAge(80);
        u.setId(123);

        String aa = us.aa(u);
        return aa;
    }

    @PostMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void test2(@RequestBody People people) {

        People save = crud.save(people);
        System.out.println(JSON.toJSONString(save));

        //crud.findById()
    }
}

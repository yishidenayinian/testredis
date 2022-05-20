package com.example.testredis.testCurdRepository.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testuserRepository.pojo
 * @ClassName: User
 * @Description:
 * @date 2022/4/26 19:37
 */
@RedisHash("user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    private long id;
    @Id
    private String name;

    private String sex;

    private int age;

    private List<String> phones;

    private Map<String,String> props;

    private String[] address;

}

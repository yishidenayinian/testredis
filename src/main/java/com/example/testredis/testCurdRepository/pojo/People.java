package com.example.testredis.testCurdRepository.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository.pojo
 * @ClassName: People
 * @Description:
 * @date 2022/4/28 16:18
 */
@RedisHash("people")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class People implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Indexed
    private String name;
    @Id
    private long id;

    private int age;
    private char sex;
}

package com.example.testredis.testCurdRepository.service;

import com.example.testredis.testCurdRepository.pojo.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testuserRepository
 * @ClassName: TestRedis
 * @Description:
 * @date 2022/4/26 19:19
 */
@Repository
public interface TestRedis extends CrudRepository<People, String> {


}

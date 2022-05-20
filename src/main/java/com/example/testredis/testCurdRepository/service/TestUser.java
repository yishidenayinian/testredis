package com.example.testredis.testCurdRepository.service;

import com.example.testredis.testCurdRepository.pojo.User;
import org.springframework.stereotype.Repository;


@Repository
public interface TestUser extends MyCrudRepository<User, String> {
}

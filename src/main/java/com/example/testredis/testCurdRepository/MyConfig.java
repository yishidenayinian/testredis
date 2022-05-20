package com.example.testredis.testCurdRepository;

import com.example.testredis.testCurdRepository.factory.BaseJpaRepositoryFactoryBean;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.swing.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository
 * @ClassName: MyConfig
 * @Description:
 * @date 2022/4/28 15:58
 */
/*@Configuration
@EnableJpaRepositories(basePackages = {"com.example.testredis"}, repositoryFactoryBeanClass =
        BaseJpaRepositoryFactoryBean.class)*/
public class MyConfig {
}

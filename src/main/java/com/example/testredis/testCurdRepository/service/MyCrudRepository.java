package com.example.testredis.testCurdRepository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 80779
 */
@NoRepositoryBean
public interface MyCrudRepository<T,ID extends Serializable> extends CrudRepository<T, ID>,
        JpaSpecificationExecutor<T> {

}

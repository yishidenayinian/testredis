package com.example.testredis.testCurdRepository.service.impl;

import com.example.testredis.testCurdRepository.service.MyCrudRepository;
import com.example.testredis.testCurdRepository.util.GetPro;
import com.example.testredis.testredisjson.RedisJsonClient;
import com.example.testredis.testredisjson.utils.JReJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository.service.impl
 * @ClassName: TestImpl
 * @Description:
 * @date 2022/4/27 14:39
 */
//@Component
//@Primary
public class MyCrud<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements MyCrudRepository<T, ID> {

    @Autowired
    private  JReJSON reJSON;

    @Autowired(required = false)
    public MyCrud(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
    @Override
    public <S extends T> S save(S entity) {
        String key = GetPro.getProperties(entity);
        reJSON.set(key,entity);
        return entity;
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> iterable) {

    }

    @Override
    public Optional<T> findOne(Specification<T> specification) {
        return Optional.empty();
    }

    @Override
    public List<T> findAll(Specification<T> specification) {
        return null;
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<T> specification) {
        return 0;
    }


}

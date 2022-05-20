package org.springframework.data.keyvalue.repository.support;

import com.example.testredis.testCurdRepository.util.GetPro;
import com.example.testredis.testredisjson.RedisJsonClient;
import com.example.testredis.testredisjson.utils.JReJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.keyvalue.core.IterableConverter;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author erpang
 * @PackageName: org.springframework.data.keyvalue.repository.support
 * @ClassName: SimpleKeyValueRepository
 * @Description:
 * @date 2022/4/29 13:18
 */

public class SimpleKeyValueRepository1<T, ID> implements KeyValueRepository<T, ID> {

    private String host = "47.104.191.239";
    private int port = 62379;
    Jedis jedis = new Jedis(host,port);
    JReJSON reJSON = new JReJSON(host,port);

    private final KeyValueOperations operations ;
    private final EntityInformation<T, ID> entityInformation ;


    public SimpleKeyValueRepository1(EntityInformation<T, ID> metadata, KeyValueOperations operations) {



        this.entityInformation = metadata;
        this.operations = operations;
    }


    @Override
    public <S extends T> S save(S entity) {
        String ping = jedis.ping("123");
        System.out.println(ping);
        String key = GetPro.getProperties(entity);

        reJSON.set(key,entity);
        // 后面替换验证find+vo再返回查出的结果
        return entity;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
     */
    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {

        Assert.notNull(entities, "The given Iterable of entities must not be null!");

        List<S> saved = new ArrayList<>();

        for (S entity : entities) {
            saved.add(save(entity));
        }

        return saved;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findOne(java.lang.Object)
     */
    @Override
    public Optional<T> findById(ID id) {

        Assert.notNull(id, "The given id must not be null!");

        return operations.findById(id, entityInformation.getJavaType());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#exists(java.lang.Object)
     */
    @Override
    public boolean existsById(ID id) {
        return findById(id).isPresent();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    @Override
    public List<T> findAll() {
        return IterableConverter.toList(operations.findAll(entityInformation.getJavaType()));
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
     */
    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {

        Assert.notNull(ids, "The given Iterable of id's must not be null!");

        List<T> result = new ArrayList<>();

        ids.forEach(id -> findById(id).ifPresent(result::add));

        return result;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#count()
     */
    @Override
    public long count() {
        return operations.count(entityInformation.getJavaType());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    @Override
    public void deleteById(ID id) {

        Assert.notNull(id, "The given id must not be null!");

        operations.delete(id, entityInformation.getJavaType());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    @Override
    public void delete(T entity) {

        Assert.notNull(entity, "The given entity must not be null!");

        deleteById(entityInformation.getRequiredId(entity));
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)
     */
    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {

        Assert.notNull(ids, "The given Iterable of Ids must not be null!");

        ids.forEach(this::deleteById);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
     */
    @Override
    public void deleteAll(Iterable<? extends T> entities) {

        Assert.notNull(entities, "The given Iterable of entities must not be null!");

        entities.forEach(this::delete);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#deleteAll()
     */
    @Override
    public void deleteAll() {
        operations.delete(entityInformation.getJavaType());
    }

    // -------------------------------------------------------------------------
    // Methods from PagingAndSortingRepository
    // -------------------------------------------------------------------------

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
     */
    @Override
    public Iterable<T> findAll(Sort sort) {

        Assert.notNull(sort, "Sort must not be null!");

        return operations.findAll(sort, entityInformation.getJavaType());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain
     * .Pageable)
     */
    @Override
    public Page<T> findAll(Pageable pageable) {

        Assert.notNull(pageable, "Pageable must not be null!");

        if (pageable.isUnpaged()) {
            List<T> result = findAll();
            return new PageImpl<>(result, Pageable.unpaged(), result.size());
        }

        Iterable<T> content = operations.findInRange(pageable.getOffset(), pageable.getPageSize(), pageable.getSort(),
                entityInformation.getJavaType());

        return new PageImpl<>(IterableConverter.toList(content), pageable,
                this.operations.count(entityInformation.getJavaType()));
    }


}

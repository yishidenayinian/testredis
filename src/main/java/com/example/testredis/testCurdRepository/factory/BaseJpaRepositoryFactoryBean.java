package com.example.testredis.testCurdRepository.factory;


import com.example.testredis.testCurdRepository.service.impl.MyCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * repository工厂类
 * @author : zhaoxu
 */
public class BaseJpaRepositoryFactoryBean<T extends CrudRepository<S, ID>, S, ID extends Serializable> extends  JpaRepositoryFactoryBean<T, S, ID> {

    public BaseJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new BaseRepositoryFactory(em);
    }

    private static class BaseRepositoryFactory<T, I extends Serializable>
            extends JpaRepositoryFactory {

        private final EntityManager em;

        public BaseRepositoryFactory(EntityManager em) {
            super(em);
            this.em = em;
        }

        @Override
        protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            JpaEntityInformation<?, Serializable> entityInformation = this.getEntityInformation(information.getDomainType());
            Object repository = this.getTargetRepositoryViaReflection(information, new Object[]{entityInformation, entityManager});
            Assert.isInstanceOf(MyCrud.class, repository);
            return (JpaRepositoryImplementation) repository;
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return MyCrud.class;
        }
    }
}

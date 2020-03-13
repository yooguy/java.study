package com.yooguy.java.study.springdatajap2.common;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * MyRepositoryImpl
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
public class SimpleMyRepository<T, ID extends Serializable> extends QuerydslJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}

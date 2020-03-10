package com.yooguy.java.study.jpa.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * MyRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(E object);

    List<T> findAll();

    long count();
}

package com.yooguy.java.study.springdatajap2.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * MyRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    boolean contains(T entity);

}

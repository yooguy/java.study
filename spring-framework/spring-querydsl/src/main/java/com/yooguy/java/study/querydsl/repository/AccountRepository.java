package com.yooguy.java.study.querydsl.repository;

import com.yooguy.java.study.querydsl.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * AccountRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {
}

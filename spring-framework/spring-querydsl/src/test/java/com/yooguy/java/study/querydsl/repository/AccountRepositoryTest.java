package com.yooguy.java.study.querydsl.repository;

import com.querydsl.core.types.Predicate;
import com.yooguy.java.study.querydsl.entity.Account;
import com.yooguy.java.study.querydsl.entity.QAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * AccountRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void crudRepository() {
        // given
        accountRepository.save(Account.builder()
                .firstName("jihoon")
                .lastName("yoo")
                .build());

        // when
        QAccount qAccount = QAccount.account;
        Predicate predicate = qAccount
                .firstName.containsIgnoreCase("jihoon")
                .and(qAccount.lastName.startsWith("yoo"));

        // then
        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isNotEmpty();
    }
}
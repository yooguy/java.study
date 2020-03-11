package com.yooguy.java.study.jpa.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Comment2MyRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class Comment2MyRepositoryTest {

    @Autowired
    Comment2MyRepository comment2MyRepository;

    @Test
    public void crudRepository() {
    }
}
package com.yooguy.java.study.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Application
 *
 * @author jihoon.yoo
 * @since 2020. 03. 08.
 */
@SpringBootApplication
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND) // default
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

package com.yooguy.java.study.springdatajap2.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PostRepositoryTestConfig
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public PostListener postListener() {
        return new PostListener();
    }
}

package com.yooguy.java.study.springdatajap2.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {
}

package com.yooguy.java.study.springdatajap2.post;

import com.yooguy.java.study.springdatajap2.common.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository<Post> {
}

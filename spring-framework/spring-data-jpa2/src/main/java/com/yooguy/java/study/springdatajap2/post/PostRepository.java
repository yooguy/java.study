package com.yooguy.java.study.springdatajap2.post;

import com.yooguy.java.study.springdatajap2.common.MyRepository;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository<Post> {
}

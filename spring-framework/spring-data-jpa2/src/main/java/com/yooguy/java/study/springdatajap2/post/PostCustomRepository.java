package com.yooguy.java.study.springdatajap2.post;

import java.util.List;

/**
 * PostCustomRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
public interface PostCustomRepository {

    List<Post> findMyPost();
}

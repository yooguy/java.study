package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}

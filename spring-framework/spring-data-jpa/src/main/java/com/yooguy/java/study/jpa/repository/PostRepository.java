package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);
}

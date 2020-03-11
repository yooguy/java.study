package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Comment2MyRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
public interface Comment2MyRepository extends MyRepository<Comment, Long> {

    @Query("SELECT c FROM Comment AS c")
    List<Comment> findByTitleContains(String keyword);
}

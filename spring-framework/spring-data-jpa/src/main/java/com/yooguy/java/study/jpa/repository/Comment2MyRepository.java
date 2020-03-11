package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

/**
 * Comment2MyRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
public interface Comment2MyRepository extends MyRepository<Comment, Long> {

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual(String comment, int likeCount);

    Page<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);

    Stream<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String comment);
}

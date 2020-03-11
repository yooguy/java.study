package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * Comment2MyRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
public interface CommentAsyncMyRepository extends JpaRepository<Comment, Long> {

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual(String comment, int likeCount);

    Page<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);
}

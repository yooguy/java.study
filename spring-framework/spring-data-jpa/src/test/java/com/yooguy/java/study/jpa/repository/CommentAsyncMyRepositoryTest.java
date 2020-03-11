package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CommentAsyncMyRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
@DataJpaTest
class CommentAsyncMyRepositoryTest {

    @Autowired
    CommentAsyncMyRepository commentAsyncMyRepository;

    @Test
    public void crudRepository() throws ExecutionException, InterruptedException {
        // given
        Comment comment1 = Comment.builder().likeCount(5).comment("spring data 1 jpa").build();
        Comment comment2 = Comment.builder().likeCount(232).comment("HIBERNATE spring data 10").build();
        Comment comment3 = Comment.builder().likeCount(24).comment("data 100 jpa").build();

        commentAsyncMyRepository.save(comment1);
        commentAsyncMyRepository.save(comment2);
        commentAsyncMyRepository.save(comment3);

        commentAsyncMyRepository.flush();

        // when1 - sync
        List<Comment> syncResult = commentAsyncMyRepository.findAll();
        System.out.println("Sync ========");
        assertThat(syncResult.size()).isEqualTo(3);

        // when2
        ListenableFuture<List<Comment>> future = commentAsyncMyRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual("spring", 10);

        System.out.println("========");
        System.out.println("is done?"  + future.isDone());

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> comments) {
                System.out.println("Async =========");
                System.out.println(comments.size()); // issue : expected : 2, result : 0
            }
        });
    }
}
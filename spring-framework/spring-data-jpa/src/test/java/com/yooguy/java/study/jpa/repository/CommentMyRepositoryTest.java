package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CommentMyRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@DataJpaTest
class CommentMyRepositoryTest {

    @Autowired
    CommentMyRepository commentMyRepository;

    @Test
    public void crudRepository() {
        // given
        Comment comment1 = Comment.builder().comment("Hello comment").build();
        Comment comment2 = Comment.builder().comment("Hi comment").build();

        // when
        Comment result1 = commentMyRepository.save(comment1);
        Comment result2 = commentMyRepository.save(comment2);
        List<Comment> results = commentMyRepository.findAll();

        // then
        assertThat(result1).isEqualTo(comment1);
        assertThat(result2).isEqualTo(comment2);
        assertThat(results.size()).isEqualTo(2);

        // when
        Optional<Comment> commentById = commentMyRepository.findById(100L);

        // then
        assertThat(commentById).isEmpty();

        // when
        // commentMyRepository.findById(null); // nonnull
    }
}
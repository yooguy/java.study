package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CommentRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crudRepository() {
        // given
        Comment comment1 = new Comment();
        comment1.setComment("Hello comment");

        Comment comment2 = new Comment();
        comment2.setComment("Hi comment");

        // when
        Comment result1 = commentRepository.save(comment1);
        Comment result2 = commentRepository.save(comment2);
        List<Comment> comments = commentRepository.findAll();

        // then
        assertThat(result1).isEqualTo(comment1);
        assertThat(result2).isEqualTo(comment2);
        assertThat(comments.size()).isEqualTo(2);
    }

}
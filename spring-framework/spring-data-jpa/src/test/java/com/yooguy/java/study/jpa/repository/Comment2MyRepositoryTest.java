package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Comment2MyRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 11.
 */
@DataJpaTest
class Comment2MyRepositoryTest {

    @Autowired
    Comment2MyRepository comment2MyRepository;

    @Test
    public void crudRepository() {
        // given
        Comment comment1 = Comment.builder().likeCount(5).comment("spring data 1 jpa").build();
        Comment comment2 = Comment.builder().likeCount(232).comment("HIBERNATE spring data 10").build();
        Comment comment3 = Comment.builder().likeCount(24).comment("data 100 jpa").build();

        comment2MyRepository.save(comment1);
        comment2MyRepository.save(comment2);
        comment2MyRepository.save(comment3);

        // when1
        List<Comment> result1 = comment2MyRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThanEqual("Spring", 1);

        // when2
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC,"likeCount"));
        Page<Comment> result2 = comment2MyRepository.findByCommentContainsIgnoreCase("spring", pageRequest);

        // when3
        Stream<Comment> result3 = comment2MyRepository.findByCommentContainsIgnoreCaseOrderByLikeCountAsc("data");


        // then1
        assertThat(result1.size()).isEqualTo(2);

        // then2
        assertThat(result2.getTotalElements()).isEqualTo(2);
        assertThat(result2.getNumberOfElements()).isEqualTo(2);
        assertThat(result2.getSize()).isEqualTo(10);
        assertThat(result2).first().hasFieldOrPropertyWithValue("likeCount", 232);

        // then3
        assertThat(result3.findFirst().get().getLikeCount()).isEqualTo(5);
        result3.close();
    }
}
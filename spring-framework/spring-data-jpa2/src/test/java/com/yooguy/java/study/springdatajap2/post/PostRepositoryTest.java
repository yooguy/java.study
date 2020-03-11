package com.yooguy.java.study.springdatajap2.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PostRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepository() {
        // when
        List<Post> posts = postRepository.findMyPost();

        // then
        assertThat(posts).isEmpty();
        assertThat(postRepository).isNotNull();
    }
}
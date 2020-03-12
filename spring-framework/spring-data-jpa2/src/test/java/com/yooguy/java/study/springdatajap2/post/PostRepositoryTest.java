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
        // given
        Post post = new Post();
        post.setTitle("hibernate");

        // when
        postRepository.save(post);
        List<Post> result1 = postRepository.findMyPost();

        // then
        assertThat(result1.size()).isEqualTo(1);

        // when
        postRepository.delete(post);
        List<Post> result2 = postRepository.findMyPost();
        assertThat(result2.size()).isEqualTo(0);
    }
}
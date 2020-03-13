package com.yooguy.java.study.springdatajap2.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PostRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event() {
        Post post = new Post();
        post.setTitle("event!!");
        PostPublishedEvent event = new PostPublishedEvent(post);

        applicationContext.publishEvent(event);
    }

    @Test
    public void crudRepository() {
        // given
        Post post = new Post();
        post.setTitle("hibernate");

        // when, then
        assertThat(postRepository.contains(post)).isFalse();

        // when
        postRepository.save(post.publish());
        List<Post> result1 = postRepository.findMyPost();

        // when, then
        assertThat(postRepository.contains(post)).isTrue();

        // then
        assertThat(result1.size()).isEqualTo(1);

        // when
        postRepository.delete(post);
        List<Post> result2 = postRepository.findMyPost();
        assertThat(result2.size()).isEqualTo(0);
    }
}
package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Post;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * PostRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        // given
        Post post1 = new Post();
        post1.setTitle("hello spring boot common");

        Post post2 = new Post();
        post2.setTitle("hello spring framework common");

        Post post3 = new Post();
        post3.setTitle("hello summer boot common");

        // when
        List<Post> savedPosts = postRepository.saveAll(Lists.list(post1, post2, post3));

        // then
        assertThat(savedPosts.get(0).getId()).isNotNull();

        // when
        List<Post> posts = postRepository.findAll();

        // then
        assertThat(posts.size()).isEqualTo(3);
        assertThat(posts).contains(post1);

        // when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));

        // then
        assertThat(page.getTotalElements()).isEqualTo(3);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(3);

        // when
        Page<Post> titlePage = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        // then
        assertThat(titlePage.getTotalElements()).isEqualTo(2);
        assertThat(titlePage.getNumber()).isEqualTo(0);
        assertThat(titlePage.getSize()).isEqualTo(10);
        assertThat(titlePage.getNumberOfElements()).isEqualTo(2);

        // when
        long count = postRepository.countByTitleContains("spring");

        // then
        assertThat(count).isEqualTo(2L);
    }
}
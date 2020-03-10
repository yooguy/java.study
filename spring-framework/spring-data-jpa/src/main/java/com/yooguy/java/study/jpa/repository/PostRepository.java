package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * PostRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@Repository
@Transactional
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post) {
        entityManager.persist(post);
        return post;
    }

    public void delete(Post post) {
        entityManager.remove(post);
    }

    public List<Post> findAll() {
        return entityManager.createQuery("select p from Post as p", Post.class)
                .getResultList();
    }
}

package com.yooguy.java.study.jpa;

import com.yooguy.java.study.jpa.post.Post;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * QueryRunner
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@Component
@Transactional
public class QueryRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // JPQL (HQL)
        TypedQuery<Post> jpqlQuery = entityManager.createQuery("SELECT p from Post AS p", Post.class);
        jpqlQuery.getResultList().forEach(System.out::println);

        System.out.println("====================================================");

        // Criteria
        CriteriaQuery<Post> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root);

        List<Post> criteriaPosts = entityManager.createQuery(criteriaQuery).getResultList();
        criteriaPosts.forEach(System.out::println);

        System.out.println("====================================================");

        // native
        List<Post> nativePosts = entityManager.createNativeQuery("select * from post", Post.class).getResultList();
        nativePosts.forEach(System.out::println);
    }
}

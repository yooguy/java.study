package com.yooguy.java.study.jpa;

import com.yooguy.java.study.jpa.post.Comment;
import com.yooguy.java.study.jpa.post.Post;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * JpaRunner
 *
 * @author jihoon.yoo
 * @since 2020. 03. 09.
 */
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//       Post post = new Post();
//       post.setTitle("Spring Data JPA 언제 보는가...?");
//
//       Comment comment = new Comment();
//       comment.setComment("빨리 보고 싶어요.");
//       post.addComment(comment);
//
//       Comment comment1 = new Comment();
//       comment1.setComment("곧 보여드릴게요.");
//       post.addComment(comment1);
//
//       Session session = entityManager.unwrap(Session.class);
//       session.save(post);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 4L);
        System.out.println("==============");
        System.out.println(post.getTitle());

        post.getComments().stream().forEach(comment -> {
            System.out.println("댓글 ID : " + comment.getId() + " comment : " + comment.getComment());
        });

//        Session session = entityManager.unwrap(Session.class);
//        Comment comment = session.get(Comment.class, 5L);
//        System.out.println("==============");
//        System.out.println(comment.getComment());
    }
}

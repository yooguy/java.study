package com.yooguy.java.study.jpa.repository;

import com.yooguy.java.study.jpa.post.Comment;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * CommentRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 10.
 */
@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository {

    Comment save(Comment comment);

    List<Comment> findAll();
}

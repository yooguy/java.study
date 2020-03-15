package com.yooguy.java.study.springdatajap2.article;

import com.yooguy.java.study.springdatajap2.common.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * ArticleRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
public interface ArticleRepository extends MyRepository<Article, Long> {

    List<Article> findByTitleStartsWith(String title, Sort sort);

    @Query("SELECT a FROM Article AS a WHERE a.id = ?1")
    List<Article> findIdentity(Long id);

    @Query("SELECT a FROM Article AS a WHERE a.title = ?1")
    List<Article> findTit(String title);

    @Query("SELECT a FROM Article AS a WHERE a.title = ?1")
    List<Article> findByTitle(String title, Sort sort);
}

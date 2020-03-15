package com.yooguy.java.study.springdatajap2.article;

import com.yooguy.java.study.springdatajap2.common.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ArticleRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
public interface ArticleRepository extends MyRepository<Article, Long> {

    List<Article> findByTitleStartsWith(String title, Sort sort);

    @Query("SELECT a FROM #{#entityName} AS a WHERE a.id = :id")
    List<Article> findIdentity(@Param("id") Long id);

    @Query("SELECT a FROM #{#entityName} AS a WHERE a.title = :title")
    List<Article> findTit(@Param("title") String title);

    @Query("SELECT a FROM #{#entityName} AS a WHERE a.title = :title")
    List<Article> findByTitle(@Param("title") String keyword, Sort sort);
}

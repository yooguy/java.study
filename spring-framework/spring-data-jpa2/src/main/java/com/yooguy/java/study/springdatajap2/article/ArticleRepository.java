package com.yooguy.java.study.springdatajap2.article;

import com.yooguy.java.study.springdatajap2.common.MyRepository;

import java.util.List;

/**
 * ArticleRepository
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
public interface ArticleRepository extends MyRepository<Article, Long> {

    List<Article> findByTitleStartsWith(String title);

    List<Article> findIdentity(Long id);

    List<Article> findTit(String title);

    List<Article> findByTitle(String title);
}

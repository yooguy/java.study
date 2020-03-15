package com.yooguy.java.study.springdatajap2.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ArticleRepositoryTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
@DataJpaTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save() {
        // when1. transient -> save(persist)
        Article transientArticle = Article.builder().title("jpa").build();
        Article persistArticle = articleRepository.save(transientArticle);

        // result1. transient -> save(persist) 의 경우 save 가 발생시 transient 상태의 객체가 영속화(persist) 되고, 해당 객체가 반환됨
        assertThat(entityManager.contains(transientArticle)).isTrue();
        assertThat(entityManager.contains(persistArticle)).isTrue();
        assertThat(transientArticle == persistArticle).isTrue();

        // when2. detached -> save(merge)
        Article detachedArticle = Article.builder().id(persistArticle.getId()).title("hibernate").build();
        Article mergeArticle = articleRepository.save(detachedArticle);

        // result2. detached -> save(merge) 의 경우 save 가 발생시 detached 상태의 객체의 복사(copy)된 객체가 영속화(persist)되고, 해당 객체가 반환됨
        assertThat(entityManager.contains(detachedArticle)).isFalse(); // detached 객체는 영속성 관리에 포함되지 않음
        assertThat(entityManager.contains(mergeArticle)).isTrue();
        assertThat(detachedArticle == mergeArticle).isFalse();

        // mergeArticle.setTitle("jihoon");

        List<Article> all = articleRepository.findAll();
        all.stream().forEach(item -> System.out.println("item : " + item.toString()));
        assertThat(all.get(0).getTitle()).isEqualTo("hibernate");
    }

    @Test
    void findByTitleStartsWith() {
        // given
        Article article = Article.builder().title("Spring Data Jpa").build();
        articleRepository.save(article);

        // when
        List<Article> result = articleRepository.findByTitleStartsWith("Spring", null);

        // then
        assertThat(result.get(0).getTitle()).isEqualTo("Spring Data Jpa");
    }

    @Test
    void findIdentity() {
        // given
        Article article = articleRepository.save(Article.builder().title("NamedQuery Article.findIdentity").build());

        // when
        List<Article> result = articleRepository.findIdentity(article.getId());

        // then
        assertThat(result.get(0).getId()).isEqualTo(article.getId());
    }

    @Test
    void findTit() {
        // given
        final String title = "NamedQuery Article.findTit";
        Article article = Article.builder().id(1L).title(title).build();
        articleRepository.save(article);

        // when
        List<Article> result = articleRepository.findTit(title);

        // then
        assertThat(result.get(0).getTitle()).isEqualTo(title);
    }

    @Test
    void findByTitleStartsWithSort() {
        // given
        Article article1 = Article.builder().title("jpa a").build();
        Article article2 = Article.builder().title("jpa c").build();
        Article article3 = Article.builder().title("jpa b").build();

        articleRepository.saveAll(List.of(article1, article2, article3));

        // when
        List<Article> result = articleRepository.findByTitleStartsWith("jpa", Sort.by("title").descending());

        // then
        result.stream().forEach(item -> System.out.println("item : " + item.toString()));
        assertThat(result.get(0).getTitle()).isEqualTo("jpa c");
    }

    @Test
    void findByTitleStartsWithJpaSort_unsafe() {
        // given
        Article article1 = Article.builder().title("jpa aaa").build();
        Article article2 = Article.builder().title("jpa aa").build();
        Article article3 = Article.builder().title("jpa a").build();

        articleRepository.saveAll(List.of(article1, article2, article3));

        // when
        List<Article> result = articleRepository.findByTitle("jpa aaa", JpaSort.unsafe(Sort.Direction.DESC, "LENGTH(title)"));

        // then
        result.stream().forEach(item -> System.out.println("item : " + item.toString()));
        assertThat(result.get(0).getTitle()).isEqualTo("jpa aaa");
    }
}
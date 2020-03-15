package com.yooguy.java.study.springdatajap2.article;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ArticleControllerTest
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getArticle() throws Exception {
        // given
        Article article = Article.builder().title("jpa").build();
        articleRepository.save(article);


        // when
        mockMvc.perform(get("/articles/1"))
                .andDo(print())
        // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("jpa"));
    }

    @Test
    public void getArticleByConverter() throws Exception {
        // given
        Article article = Article.builder().title("jpa").build();
        articleRepository.save(article);


        // when
        mockMvc.perform(get("/articles/dcc/1"))
                .andDo(print())
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("jpa"));
    }

    @Test
    void getArticles() throws Exception {
        // given
        Article article1 = createArticle("hibernate", DateUtil.now());
        Article article2 = createArticle("jpa", DateUtil.yesterday());
        Article article3 = createArticle("h2 database", DateUtil.tomorrow());

        articleRepository.saveAll(List.of(article1, article2, article3));

        // when
        mockMvc.perform(get("/articles")
                    .param("page", "0")
                    .param("size", "10")
                    .param("sort", "created,desc")
                    .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("h2 database"))
                .andExpect(jsonPath("$.content[1].title").value("hibernate"))
                .andExpect(jsonPath("$.content[2].title").value("jpa"));
    }

    @Test
    void getArticlesSupportHateoas() throws Exception {
        // given
        articleRepository.saveAll(createArticles(100));

        // when
        mockMvc.perform(get("/articles/hateoas")
                .param("page", "0")
                .param("size", "10")
                .param("sort", "created,desc")
                .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self.href",
                        is(containsString("/articles/hateoas?page=0&size=10&sort=created,desc&sort=title,asc"))));
    }

    Article createArticle(String title, Date created) {
        return Article.builder().title(title).created(created).build();
    }

    List<Article> createArticles(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .map(item -> createArticle(RandomString.make(5), new Date(item.longValue())))
                .collect(Collectors.toList());
    }
}
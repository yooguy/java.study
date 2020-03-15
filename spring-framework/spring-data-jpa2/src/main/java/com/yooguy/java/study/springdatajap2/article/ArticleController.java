package com.yooguy.java.study.springdatajap2.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * ArticleController
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        Optional<Article> byId = articleRepository.findById(id);
        Article article = byId.get();
        return article;
    }

    @GetMapping("/articles")
    public Page<Article> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @GetMapping("/articles/hateoas")
    public PagedModel<EntityModel<Article>> getArticlesSupportHateoas(Pageable pageable, PagedResourcesAssembler<Article> assembler) {
        return assembler.toModel(articleRepository.findAll(pageable));
    }

    /**
     * {@link DomainClassConverter#convert(Object, TypeDescriptor, TypeDescriptor)}
     * return id == null ? null : invoker.invokeFindById(id).orElse(null); // id가 존재하면 findById를 호출함
     *
     * @param article
     * @return
     */
    @GetMapping("/articles/dcc/{id}")
    public Article getArticleByDomainClassConverter(@PathVariable("id") Article article) {
        return article;
    }
}

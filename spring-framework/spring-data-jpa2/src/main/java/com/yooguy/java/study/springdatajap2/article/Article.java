package com.yooguy.java.study.springdatajap2.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Article
 *
 * @author jihoon.yoo
 * @since 2020. 03. 15.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Article.findIdentity", query = "SELECT a FROM Article AS a WHERE a.id = ?1"),
        @NamedQuery(name = "Article.findTit", query = "SELECT a FROM Article AS a WHERE a.title = ?1"),
        @NamedQuery(name = "Article.findByTitle", query = "SELECT a FROM Article AS a WHERE a.title = ?1")
})
public class Article {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}

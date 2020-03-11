package com.yooguy.java.study.springdatajap2.post;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Post
 *
 * @author jihoon.yoo
 * @since 2020. 03. 12.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;
}

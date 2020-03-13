package com.yooguy.java.study.springdatajap2.post;

import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.DomainEvents;

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
public class Post extends AbstractAggregateRoot<Post> {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    public Post publish() {
        this.registerEvent(new PostPublishedEvent(this));
        return this;
    }
}

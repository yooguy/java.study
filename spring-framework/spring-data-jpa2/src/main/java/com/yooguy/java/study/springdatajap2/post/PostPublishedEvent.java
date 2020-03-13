package com.yooguy.java.study.springdatajap2.post;

import org.springframework.context.ApplicationEvent;

/**
 * PostPublishedEvent
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
public class PostPublishedEvent extends ApplicationEvent {

    private final Post post;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }

    public Post getPost() {
        return post;
    }
}

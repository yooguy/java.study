package com.yooguy.java.study.springdatajap2.post;

import org.springframework.context.event.EventListener;

/**
 * PostListener
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
public class PostListener {

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("---------------------");
        System.out.println(event.getPost().getTitle() + " is published!!");
        System.out.println("---------------------");
    }
}

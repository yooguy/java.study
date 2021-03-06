package com.yooguy.java.study.jpa.post;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Comment
 *
 * @author jihoon.yoo
 * @since 2020. 03. 09.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private Integer likeCount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    private Date created;
}

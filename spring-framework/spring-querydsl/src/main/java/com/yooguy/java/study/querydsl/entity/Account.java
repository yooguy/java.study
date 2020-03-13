package com.yooguy.java.study.querydsl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Account
 *
 * @author jihoon.yoo
 * @since 2020. 03. 13.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;
}

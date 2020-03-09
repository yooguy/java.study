package com.yooguy.java.study.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Account
 *
 * @author jihoon.yoo
 * @since 2020. 03. 09.
 */
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
}

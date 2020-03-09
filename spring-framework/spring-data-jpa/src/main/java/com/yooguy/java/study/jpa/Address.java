package com.yooguy.java.study.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Address
 *
 * @author jihoon.yoo
 * @since 2020. 03. 09.
 */
@Getter
@Setter
@Embeddable
public class Address {

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String stage;

    @Column
    private String zipCode;
}

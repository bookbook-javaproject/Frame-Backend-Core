package com.frame.core.domain.user.domain.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;
}

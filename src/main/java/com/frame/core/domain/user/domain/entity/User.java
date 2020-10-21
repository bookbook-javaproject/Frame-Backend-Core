package com.frame.core.domain.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String email;

    @Column(nullable = false, length = 12)
    private String nickname;

    @Column(nullable = false, length = 60)
    private String password;
}

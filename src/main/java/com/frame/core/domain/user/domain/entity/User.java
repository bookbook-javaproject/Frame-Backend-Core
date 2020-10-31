package com.frame.core.domain.user.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
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

    public User changePassword(String newPassword) {
        this.password = newPassword;
        return this;
    }
}

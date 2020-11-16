package com.frame.core.domain.user.domain.entity;

import com.frame.core.domain.user.domain.entity.enums.FavoriteType;
import com.frame.core.domain.user.domain.entity.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 12)
    private String nickname;

    @Column(nullable = true, length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    private FavoriteType favoriteType;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "image_uri", nullable = true)
    private String imageUri;

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeFavoriteType(FavoriteType favoriteType) {
        this.favoriteType = favoriteType;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}

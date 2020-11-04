package com.frame.core.domain.user.domain.usecase;

public interface SetProfileUseCase {
    public void execute(String email, String nickname, String description, String favoriteType, String imageUri);
}

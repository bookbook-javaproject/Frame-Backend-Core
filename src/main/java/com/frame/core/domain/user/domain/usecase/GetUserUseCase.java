package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.User;

public interface GetUserUseCase {
    public User execute(String email);
}

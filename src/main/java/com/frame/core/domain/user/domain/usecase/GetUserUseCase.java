package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.dto.GetUserResponse;

public interface GetUserUseCase {
    public User execute(String email);
}

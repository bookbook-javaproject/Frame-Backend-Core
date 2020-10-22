package com.frame.core.domain.user.service;

import com.frame.core.domain.user.dto.ChangePasswordRequest;
import com.frame.core.domain.user.dto.RegisterRequest;

public interface UserService {
    public void registerService(RegisterRequest request);

    public void changePasswordService(ChangePasswordRequest request);
}

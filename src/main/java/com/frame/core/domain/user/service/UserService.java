package com.frame.core.domain.user.service;

import com.frame.core.domain.user.dto.*;

public interface UserService {
    public void registerService(RegisterRequest request);

    public LoginResponse login(LoginRequest request);

    public void changePasswordService(ChangePasswordRequest request);

    public void setProfile(SetProfileRequest request);
}

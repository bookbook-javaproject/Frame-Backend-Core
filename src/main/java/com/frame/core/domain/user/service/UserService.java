package com.frame.core.domain.user.service;

import com.frame.core.domain.user.dto.*;

public interface UserService {
    public void registerService(RegisterRequest request);

    public LoginResponse login(LoginRequest request);

    public void changePasswordService(ChangePasswordRequest request);

    public void setProfile(SetProfileRequest request);

    public void setRelation(RelationRequest request);

    public GetRelationResponse getRelation(String email);

    public GetRelationNumberResponse getRelationNumber(String email);
}

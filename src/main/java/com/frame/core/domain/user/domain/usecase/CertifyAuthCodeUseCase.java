package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.EmailAuth;

public interface CertifyAuthCodeUseCase {
    public EmailAuth execute(String authCode);
}

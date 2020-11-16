package com.frame.core.domain.user.domain.usecase;


import com.frame.core.domain.user.domain.entity.EmailAuth;
import com.frame.core.domain.user.domain.repository.EmailAuthRepository;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertifyAuthCodeUseCaseImpl implements CertifyAuthCodeUseCase {
    private final EmailAuthRepository emailAuthRepository;
    private final UserRepository userRepository;

    @Override
    public EmailAuth execute(String authCode) {
        EmailAuth emailAuth = emailAuthRepository.findByAuthCode(authCode)
                .orElseThrow(NotFoundException::new);
        emailAuthRepository.delete(emailAuth);
        return emailAuth;
    }
}

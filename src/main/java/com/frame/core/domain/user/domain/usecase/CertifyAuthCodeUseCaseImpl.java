package com.frame.core.domain.user.domain.usecase;


import com.frame.core.domain.user.domain.repository.EmailAuthRepository;
import com.frame.core.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertifyAuthCodeUseCaseImpl implements CertifyAuthCodeUseCase {
    private final EmailAuthRepository emailAuthRepository;
    private final UserRepository userRepository;

    @Override
    public void execute(String authCode) {
        emailAuthRepository.findByAuthCode(authCode).ifPresent(
            emailAuth -> {
                userRepository.findById(emailAuth.getEmail()).ifPresent(
                        user -> {
                            user.certifyUser();
                            userRepository.save(user);
                        }
                );
                emailAuthRepository.delete(emailAuth);
            }
        );
    }
}

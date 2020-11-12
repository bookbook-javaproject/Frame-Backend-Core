package com.frame.core.domain.user.domain.usecase;


import com.frame.core.domain.user.domain.exception.AuthenticationFailedException;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertifyUserUseCaseImpl implements CertifyUserUseCase {
    private final UserRepository userRepository;

    private final PasswordService passwordService;

    @Override
    public void execute(String email, String password) {
        userRepository.findById(email)
                .filter(user -> passwordService.matches(password, user.getPassword()))
                .orElseThrow(AuthenticationFailedException::new);
    }
}

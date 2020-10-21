package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;

    private final PasswordService passwordService;

    @Override
    public void run(String email, String nickname, String password) {
        userRepository.save(
                User.builder()
                .email(email)
                .nickname(nickname)
                .password(passwordService.encode(password))
                .build()
        );
    }
}

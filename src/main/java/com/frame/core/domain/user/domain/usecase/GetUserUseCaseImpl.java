package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository userRepository;

    @Override
    public User execute(String email) {
        return userRepository.findById(email).orElseThrow(NotFoundException::new);
    }
}

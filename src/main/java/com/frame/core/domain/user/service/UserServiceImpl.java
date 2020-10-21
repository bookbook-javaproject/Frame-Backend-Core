package com.frame.core.domain.user.service;

import com.frame.core.domain.user.domain.usecase.CreateUserUseCase;
import com.frame.core.domain.user.dto.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateUserUseCase createUserUseCase;

    @Override
    public void registerService(RegisterRequest request) {
        createUserUseCase.run(request.getEmail(), request.getNickname(), request.getPassword());
    }
}

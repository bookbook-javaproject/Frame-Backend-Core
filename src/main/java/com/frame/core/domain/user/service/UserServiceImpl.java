package com.frame.core.domain.user.service;

import com.frame.core.domain.user.domain.usecase.CertifyUserUseCase;
import com.frame.core.domain.user.domain.usecase.ChangePasswordUseCase;
import com.frame.core.domain.user.domain.usecase.CreateUserUseCase;
import com.frame.core.domain.user.dto.ChangePasswordRequest;
import com.frame.core.domain.user.dto.LoginRequest;
import com.frame.core.domain.user.dto.LoginResponse;
import com.frame.core.domain.user.dto.RegisterRequest;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import com.frame.core.infra.springBoot.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateUserUseCase createUserUseCase;
    private final CertifyUserUseCase certifyUserUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;

    private final JwtProvider jwtProvider;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public void registerService(RegisterRequest request) {
        createUserUseCase.run(request.getEmail(), request.getNickname(), request.getPassword());
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        certifyUserUseCase.run(request.getEmail(), request.getPassword());
        return LoginResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail()))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail()))
                .build();
    }

    @Override
    public void changePasswordService(ChangePasswordRequest request) {
        changePasswordUseCase.run(authenticationFacade.getEmail(), request.getCurrentPassword(), request.getNewPassword());
    }
}

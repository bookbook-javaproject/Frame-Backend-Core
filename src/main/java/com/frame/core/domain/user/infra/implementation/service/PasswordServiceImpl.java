package com.frame.core.domain.user.infra.implementation.service;

import com.frame.core.domain.user.domain.service.PasswordService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String encode(String password) {
        return passwordEncoder().encode(password);
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}

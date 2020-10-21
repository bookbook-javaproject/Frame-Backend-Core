package com.frame.core.domain.user.domain.service;


import org.springframework.stereotype.Component;

public interface PasswordService {
    public String encode(String password);
}

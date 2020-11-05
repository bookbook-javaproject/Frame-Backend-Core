package com.frame.core.domain.user.domain.repository;

import com.frame.core.domain.user.domain.entity.EmailAuth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmailAuthRepository extends CrudRepository<EmailAuth, String> {
    Optional<EmailAuth> findByAuthCode(String authCode);
}

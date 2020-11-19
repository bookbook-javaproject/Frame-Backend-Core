package com.frame.core.domain.submission.domain.repository;

import com.frame.core.domain.submission.domain.entity.AuthorSubmissionAuth;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthorSubmissionAuthRepository extends CrudRepository<AuthorSubmissionAuth, String> {
    public Optional<AuthorSubmissionAuth> findByAuthCode(String authCode);

    public Optional<AuthorSubmissionAuth> findByEmail(String email);
}

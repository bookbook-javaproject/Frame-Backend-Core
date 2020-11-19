package com.frame.core.domain.submission.domain.usecase;

import com.frame.core.domain.submission.domain.entity.AuthorSubmissionAuth;
import com.frame.core.domain.submission.domain.repository.AuthorSubmissionAuthRepository;
import com.frame.core.domain.user.domain.entity.EmailAuth;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertifyEmailUseCaseImpl implements CertifyEmailUseCase {
    private final AuthorSubmissionAuthRepository authorSubmissionAuthRepository;

    @Override
    public void execute(String authCode) {
        AuthorSubmissionAuth auth = authorSubmissionAuthRepository.findByAuthCode(authCode)
                .orElseThrow(NotFoundException::new);
        auth.certify();
        authorSubmissionAuthRepository.save(auth);
    }
}

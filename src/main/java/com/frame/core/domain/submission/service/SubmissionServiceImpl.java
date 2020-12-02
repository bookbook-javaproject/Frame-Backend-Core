package com.frame.core.domain.submission.service;

import com.frame.core.domain.submission.domain.usecase.CertifyEmailUseCase;
import com.frame.core.domain.submission.domain.usecase.CreateAnthologyApplicationUseCase;
import com.frame.core.domain.submission.domain.usecase.CreateAuthorApplicationUseCase;
import com.frame.core.domain.submission.domain.usecase.SendEmailForAuthUseCase;
import com.frame.core.domain.submission.dto.ApplyAnthologyRequest;
import com.frame.core.domain.submission.dto.ApplyAuthorRequest;
import com.frame.core.domain.submission.dto.SendEmailForAuthRequest;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {
    private final AuthenticationFacade authenticationFacade;

    private final CertifyEmailUseCase certifyEmailUseCase;
    private final CreateAnthologyApplicationUseCase createAnthologyApplicationUseCase;
    private final CreateAuthorApplicationUseCase createAuthorApplicationUseCase;
    private final SendEmailForAuthUseCase sendEmailForAuthUseCase;

    @Override
    public void applyAnthology(ApplyAnthologyRequest request) {
        createAnthologyApplicationUseCase.execute(
                authenticationFacade.getEmail(), request.getLink(), request.getFileId()
        );
    }

    @Override
    public void applyAuthor(ApplyAuthorRequest request) {
        createAuthorApplicationUseCase.execute(
                authenticationFacade.getEmail(), request.getLink(), request.getGoal());
    }

    @Override
    public void certifyEmail(String authCode) {
        certifyEmailUseCase.execute(authCode);
    }

    @Override
    public void sendAuthCode(SendEmailForAuthRequest request) {
        sendEmailForAuthUseCase.execute(request.getEmail());
    }
}

package com.frame.core.domain.submission.service;

import com.frame.core.domain.submission.dto.ApplyAnthologyRequest;
import com.frame.core.domain.submission.dto.ApplyAuthorRequest;
import com.frame.core.domain.submission.dto.SendEmailForAuthRequest;

public interface SubmissionService {
    public void sendAuthCode(SendEmailForAuthRequest request);

    public void certifyEmail(String authCode);

    public void applyAuthor(ApplyAuthorRequest request);

    public void applyAnthology(ApplyAnthologyRequest request);
}

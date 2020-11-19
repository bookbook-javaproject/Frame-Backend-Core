package com.frame.core.domain.submission.domain.usecase;

import com.frame.core.domain.submission.domain.entity.AuthorSubmission;
import com.frame.core.domain.submission.domain.repository.AuthorSubmissionAuthRepository;
import com.frame.core.domain.submission.domain.repository.AuthorSubmissionRepository;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAuthorApplicationUseCaseImpl implements CreateAuthorApplicationUseCase {
    private final AuthorSubmissionAuthRepository authorSubmissionAuthRepository;
    private final AuthorSubmissionRepository authorSubmissionRepository;

    @Override
    public void execute(String email, String link, String goal) {
        authorSubmissionAuthRepository.findById(email).ifPresent(
                auth -> {
                    if (auth.getCertification().equals(false)) throw new UnAuthorizedException();
                    authorSubmissionRepository.save(
                            AuthorSubmission.builder()
                            .email(email)
                            .goal(goal)
                            .link(link)
                            .build()
                    );
                }
        );
    }
}

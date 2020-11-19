package com.frame.core.domain.submission.domain.usecase;


import com.frame.core.domain.submission.domain.entity.AnthologySubmission;
import com.frame.core.domain.submission.domain.entity.AuthorSubmission;
import com.frame.core.domain.submission.domain.repository.AnthologySubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAnthologyApplicationUseCaseImpl implements CreateAnthologyApplicationUseCase {
    private final AnthologySubmissionRepository anthologySubmissionRepository;

    @Override
    public void execute(String email, String link, String fileId) {
        anthologySubmissionRepository.save(
                AnthologySubmission.builder()
                        .email(email)
                        .fileId(fileId)
                        .link(link)
                        .build()
        );
    }
}

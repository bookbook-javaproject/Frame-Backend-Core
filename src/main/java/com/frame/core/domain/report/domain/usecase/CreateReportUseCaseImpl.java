package com.frame.core.domain.report.domain.usecase;

import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.report.domain.entity.Report.Report;
import com.frame.core.domain.report.domain.repository.ReportRepository;
import com.frame.core.global.exceptions.BadRequestException;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CreateReportUseCaseImpl implements CreateReportUseCase {
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    @Override
    public void execute(String email, Long postId, String content) {
        postRepository.findById(postId).orElseThrow(NotFoundException::new);

        for (Report report : reportRepository.findAllByPostNumber(postId)) {
          if (report.getReporter().equals(email)) throw new BadRequestException();
        }
        Report report = Report.builder()
                .content(content)
                .postNumber(postId)
                .reporter(email)
                .createdAt(LocalDateTime.now())
                .build();
        reportRepository.save(report);
    }
}

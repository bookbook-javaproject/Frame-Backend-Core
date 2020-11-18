package com.frame.core.domain.report.service;

import com.frame.core.domain.report.domain.dto.CreateReportRequest;
import com.frame.core.domain.report.domain.usecase.CreateReportUseCase;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final AuthenticationFacade authenticationFacade;

    private final CreateReportUseCase createReportUseCase;

    @Override
    public void createReport(CreateReportRequest request) {
        createReportUseCase.execute(
                authenticationFacade.getEmail(),
                request.getPostId(),
                request.getContent()
        );
    }
}

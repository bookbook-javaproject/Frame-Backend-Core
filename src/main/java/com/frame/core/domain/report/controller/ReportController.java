package com.frame.core.domain.report.controller;

import com.frame.core.domain.report.domain.dto.CreateReportRequest;
import com.frame.core.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReport(@RequestBody @Valid CreateReportRequest request) {
        reportService.createReport(request);
    }
}

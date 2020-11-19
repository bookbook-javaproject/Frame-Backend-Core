package com.frame.core.domain.submission.controller;


import com.frame.core.domain.post.dto.*;
import com.frame.core.domain.post.service.PostService;
import com.frame.core.domain.submission.dto.ApplyAnthologyRequest;
import com.frame.core.domain.submission.dto.ApplyAuthorRequest;
import com.frame.core.domain.submission.dto.SendEmailForAuthRequest;
import com.frame.core.domain.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService submissionService;

    @PostMapping("/author/auth")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmailForAuth(@RequestBody @Valid SendEmailForAuthRequest request) {
        submissionService.sendAuthCode(request);
    }

    @GetMapping("/author/auth")
    @ResponseStatus(HttpStatus.OK)
    public void CertifyEmail(@RequestParam("code") String authCode) {
        submissionService.certifyEmail(authCode);
    }

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public void ApplyAuthor(@RequestBody @Valid ApplyAuthorRequest request) {
        submissionService.applyAuthor(request);
    }

    @PostMapping("/anthology")
    @ResponseStatus(HttpStatus.CREATED)
    public void ApplyAnthology(@RequestBody @Valid ApplyAnthologyRequest request) {
        submissionService.applyAnthology(request);
    }
}
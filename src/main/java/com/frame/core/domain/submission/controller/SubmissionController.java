package com.frame.core.domain.submission.controller;


import com.frame.core.domain.post.dto.*;
import com.frame.core.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void somethingshit() {
    }
}
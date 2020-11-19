package com.frame.core.domain.notice.controller;

import com.frame.core.domain.notice.dto.NoticeResponse;
import com.frame.core.domain.notice.service.NoticeService;
import com.frame.core.domain.post.dto.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public NoticeResponse getNotices() {
        return noticeService.getNotices();
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public void getNoticeDetail(@RequestParam("id") String id) {

    }

}

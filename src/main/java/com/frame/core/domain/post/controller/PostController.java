package com.frame.core.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    public void createPost() {

    }

    public void getPosts() {

    }

    public void getUserPosts() {

    }

    @GetMapping("/detail")
    public void getPost() {

    }

    public void comment() {

    }

    public void heart() {

    }
}

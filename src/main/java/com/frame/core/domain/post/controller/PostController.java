package com.frame.core.domain.post.controller;

import com.frame.core.domain.post.dto.CommentRequest;
import com.frame.core.domain.post.dto.CreatePostRequest;
import com.frame.core.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody @Valid CreatePostRequest request) {
        postService.createPost(request);
    }

    public void getPosts() {

    }

    public void getUserPosts() {

    }

    @GetMapping("/detail")
    public void getPost() {

    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void comment(@RequestBody @Valid CommentRequest request) {
        postService.comment(request);
    }

    public void heart() {

    }
}

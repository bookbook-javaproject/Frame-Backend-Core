package com.frame.core.domain.post.controller;

import com.frame.core.domain.post.dto.*;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetPostResponse getPosts(@RequestBody @Valid GetPostRequest request) {
        return postService.getPosts(request);
    }

    public void getUserPosts() {

    }

    @GetMapping("/detail")
    public GetPostDetailResponse getPostDetail(@RequestParam Long postId) {
        return postService.getPostDetail(postId);
    }

    @DeleteMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public void deletePostDetail(@RequestParam Long postId) {
        postService.deletePostDetail(postId);
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void comment(@RequestBody @Valid CommentRequest request) {
        postService.comment(request);
    }

    @PatchMapping("/heart")
    @ResponseStatus(HttpStatus.OK)
    public void sympathize(@RequestBody @Valid SympathizeRequest request) {
        postService.sympathize(request);
    }
}

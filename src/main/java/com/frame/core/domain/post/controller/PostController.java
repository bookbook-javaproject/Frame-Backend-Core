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
    public GetPostsResponse getPosts(@RequestParam("sort-type") String sortType) {
        return postService.getPosts(sortType);
    }

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public GetUserPostsResponse getUserPosts(@RequestParam("access-type") String accessType) {
        return postService.getUserPosts(accessType);
    }

    @GetMapping("/my/sympathetic")
    @ResponseStatus(HttpStatus.OK)
    public GetSympatheticPostsResponse getSympatheticPosts() {
        return postService.getSympatheticPosts();
    }

    @GetMapping("/highlight")
    @ResponseStatus(HttpStatus.OK)
    public GetPostsResponse getHighLightPost() {
        return postService.getHighlightPost();
    }

    @GetMapping("/detail")
    public GetPostDetailResponse getPostDetail(@RequestParam("post-id") Long postId) {
        return postService.getPostDetail(postId);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody @Valid UpdatePostRequest request) {
        postService.updatePost(request);
    }
  
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestBody @Valid DeletePostRequest request) {
        postService.deletePost(request);
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

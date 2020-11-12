package com.frame.core.domain.post.dto;

import com.frame.core.domain.post.domain.entity.Post.Comment;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
public class GetPostDetailResponse {
    private Long postId;

    private String writer;

    private String content;

    private LocalDateTime createdAt;

    private List<String> hearts;

    private List<Comment> comments;
}

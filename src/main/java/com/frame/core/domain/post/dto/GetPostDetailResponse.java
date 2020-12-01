package com.frame.core.domain.post.dto;

import com.frame.core.domain.post.domain.entity.Post.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
public class GetPostDetailResponse {
    private Long postId;

    private UserPreview writer;

    private String content;

    private LocalDateTime createdAt;

    private List<String> hearts;

    private List<CommentPreview> comments;
}

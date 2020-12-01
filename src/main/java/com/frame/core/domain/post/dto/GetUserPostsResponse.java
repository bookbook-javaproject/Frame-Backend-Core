package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Builder
@Getter
public class GetUserPostsResponse {
    private List<UserPostPreview> userPostPreviews;
}

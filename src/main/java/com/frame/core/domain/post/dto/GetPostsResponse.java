package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetPostsResponse {
    private List<PostPreview> posts;
}

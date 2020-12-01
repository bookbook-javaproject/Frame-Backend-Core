package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import com.frame.core.domain.user.domain.entity.User;

@Builder
@Getter
public class GetUserPostsResponse {
    private List<UserPostPreview> userPostPreviews;
    private User writer;
}

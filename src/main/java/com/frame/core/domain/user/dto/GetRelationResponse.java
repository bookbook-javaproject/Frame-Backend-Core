package com.frame.core.domain.user.dto;


import com.frame.core.domain.post.dto.UserPreview;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetRelationResponse {
    private List<UserPreview> follower;

    private List<UserPreview> following;
}

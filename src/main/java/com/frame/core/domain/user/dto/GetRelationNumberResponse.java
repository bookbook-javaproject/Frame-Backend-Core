package com.frame.core.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetRelationNumberResponse {
    private Integer follower;
    private Integer following;
}

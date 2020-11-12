package com.frame.core.domain.user.dto;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetRelationResponse {
    private List<String> follower;

    private List<String> following;
}

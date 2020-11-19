package com.frame.core.domain.submission.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash(value = "author_submission")
@AllArgsConstructor
public class AuthorSubmissionAuth {
    @Id
    private String email;

    @Indexed
    private String authCode;

    @Indexed
    private Boolean certification;

    public void certify() {
        certification = true;
    }
}

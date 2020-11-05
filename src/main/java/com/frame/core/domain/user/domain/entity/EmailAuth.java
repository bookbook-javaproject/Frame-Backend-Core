package com.frame.core.domain.user.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash(value = "email_code")
@AllArgsConstructor
public class EmailAuth {
    @Id
    private String email;

    @Indexed
    private String authCode;
}

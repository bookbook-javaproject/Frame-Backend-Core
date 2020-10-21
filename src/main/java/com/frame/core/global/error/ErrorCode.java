package com.frame.core.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "Bad Request"),
    CONFLICT(409, "Conflict");

    private final int status;

    private final String message;
}

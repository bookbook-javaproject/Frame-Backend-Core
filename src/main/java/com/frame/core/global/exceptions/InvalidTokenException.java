package com.frame.core.global.exceptions;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public InvalidTokenException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}

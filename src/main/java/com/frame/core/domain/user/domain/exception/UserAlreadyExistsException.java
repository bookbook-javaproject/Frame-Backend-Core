package com.frame.core.domain.user.domain.exception;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super(ErrorCode.CONFLICT);
    }
}

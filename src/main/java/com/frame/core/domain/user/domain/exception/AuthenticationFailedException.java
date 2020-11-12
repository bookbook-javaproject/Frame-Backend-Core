package com.frame.core.domain.user.domain.exception;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class AuthenticationFailedException extends BusinessException {
    public AuthenticationFailedException() {super(ErrorCode.AUTHENTICATION_FAILED);}
}

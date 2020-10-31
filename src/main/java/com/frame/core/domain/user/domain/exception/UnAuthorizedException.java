package com.frame.core.domain.user.domain.exception;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class UnAuthorizedException extends BusinessException {
    public UnAuthorizedException() {super(ErrorCode.UNAUTHORIZED);}
}

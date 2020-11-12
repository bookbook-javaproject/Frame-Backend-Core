package com.frame.core.global.exceptions;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class BadRequestException extends BusinessException {
    public BadRequestException() { super(ErrorCode.BAD_REQUEST);}
}

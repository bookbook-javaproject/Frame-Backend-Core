package com.frame.core.global.exceptions;

import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException() {
        super(ErrorCode.CONFLICT);
    }
}
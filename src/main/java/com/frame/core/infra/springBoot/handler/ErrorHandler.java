package com.frame.core.infra.springBoot.handler;


import com.frame.core.global.error.BusinessException;
import com.frame.core.global.error.ErrorCode;
import com.frame.core.global.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(), e.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}

package com.hello.controller;

import com.hello.exception.AccessLimitException;
import com.hello.util.RespUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(value = AccessLimitException.class)
    public Object accessLimitExceptionHandler(AccessLimitException e) {
        return RespUtil.resp(-100, e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        return RespUtil.resp(-1, e.getMessage());
    }
}

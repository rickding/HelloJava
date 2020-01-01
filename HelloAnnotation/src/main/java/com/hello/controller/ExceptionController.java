package com.hello.controller;

import com.hello.interceptor.AccessLimitException;
import com.hello.util.RespUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = AccessLimitException.class)
    public Object accessLimitExceptionHandler(AccessLimitException e) {
        return RespUtil.resp(-100, e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        return RespUtil.resp(-1, e.getMessage());
    }
}

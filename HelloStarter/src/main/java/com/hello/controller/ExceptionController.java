package com.hello.controller;

import com.hello.exception.AccessLimitException;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Object shiroExceptionHandler(ShiroException e) {
        return new HashMap<String, Object>() {{
            put("msg", e.getMessage());
        }};
    }

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(value = AccessLimitException.class)
    public Object accessLimitExceptionHandler(AccessLimitException e) {
        return new HashMap<String, Object>() {{
            put("msg", e.getMessage());
        }};
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        return new HashMap<String, Object>() {{
            put("msg", e.getMessage());
        }};
    }
}

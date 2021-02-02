package com.hello.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dingxl
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler
    @ResponseBody
    public String authorizationException(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    public String authenticationException(AuthenticationException e) {
        log.error("没有通过用户认证！", e);
        return e.getMessage();
    }
}

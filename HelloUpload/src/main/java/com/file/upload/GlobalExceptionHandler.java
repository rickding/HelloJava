package com.file.upload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    ResponseEntity<?> handleMutlipartException(HttpServletRequest request, Throwable e) {
        Integer code = (Integer) request.getAttribute("javax.servert.error.status_code");
        HttpStatus status = code == null ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.valueOf(code);
        return new ResponseEntity(e.getMessage(), status);
    }
}

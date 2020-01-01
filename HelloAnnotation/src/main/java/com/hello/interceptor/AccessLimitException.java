package com.hello.interceptor;

import javax.servlet.ServletException;

public class AccessLimitException extends ServletException {
    public AccessLimitException() {
        super("access rate is limited");
    }
}

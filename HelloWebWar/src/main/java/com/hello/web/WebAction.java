package com.hello.web;

import org.springframework.stereotype.Service;

@Service
public class WebAction {
    public String action() {
        return this.getClass().getName() + ".action";
    }
}

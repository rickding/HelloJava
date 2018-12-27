package com.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping("chk")
    public String chk() {
        return "ok, prefer-web-inf-classes, 管理系统0.0.1";
    }
}

package com.hello.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2017/5/28.
 */
@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "Hello Spring Boot";
    }
}

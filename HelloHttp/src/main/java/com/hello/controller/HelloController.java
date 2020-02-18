package com.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping
public class HelloController {
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public Object hello(@RequestParam("name") String name) {
        return new HashMap<String, Object>() {{
            put("code", "ok");
            put("msg", String.format("hello, %s", name));
        }};
    }
}

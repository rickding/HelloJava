package com.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Map<String, Object> dataMap) {
        dataMap.put("str", "WebController.index");
        return "/index";
    }
}

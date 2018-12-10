package com.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebController {
    @RequestMapping("/con")
    public String con(Map<String, Object> dataMap) {
        dataMap.put("str", "WebController.con");
        return "/con";
    }
}

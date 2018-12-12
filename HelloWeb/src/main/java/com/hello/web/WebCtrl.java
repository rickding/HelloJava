package com.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCtrl {
    @RequestMapping("/ctrl")
    public String ctrl(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCtrl.ctrl");
        return "/ctrl";
    }
}

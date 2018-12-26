package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    WebAction webAction;

    @RequestMapping("/ctrl")
    public String ctrl(Map<String, Object> dataMap) {
        dataMap.put("str", this.getClass().getName() + ".ctrl, " + webAction.action());
        return "/ctrl";
    }
}

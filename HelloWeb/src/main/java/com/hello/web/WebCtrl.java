package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCtrl {
    @Autowired
    WebAction webAction;

    @RequestMapping("/ctrl")
    public String ctrl(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCtrl.ctrl, " + webAction.action());
        return "/ctrl";
    }
}

package com.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerCtrl {
    @Autowired
    WebCustomerAction webAction;

    @RequestMapping("/ctrl_customer")
    public String ctrl_customer(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerCtrl.ctrl_customer, " + webAction.action());
        return "/ctrl_customer";
    }
}

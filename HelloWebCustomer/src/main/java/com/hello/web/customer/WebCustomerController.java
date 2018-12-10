package com.hello.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerController {
    @RequestMapping("/")
    public String index(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerController.index");
        return "/index";
    }
}

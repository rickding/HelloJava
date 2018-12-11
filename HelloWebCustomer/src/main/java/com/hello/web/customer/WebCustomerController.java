package com.hello.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerController {
    @RequestMapping("/con_customer")
    public String con_customer(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerController.con_customer");
        return "/con_customer";
    }
}

package com.hello.web.customer;

import com.hello.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerController extends WebController {
    @RequestMapping("/ctrl_customer")
    public String ctrl_customer(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerController.ctrl_customer");
        return "/ctrl_customer";
    }
}

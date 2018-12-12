package com.hello.web_customer;

import com.hello.web.WebCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerCtrl extends WebCtrl {
    @RequestMapping("/ctrl_customer")
    public String ctrl_customer(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerCtrl.ctrl_customer");
        return "/ctrl_customer";
    }
}

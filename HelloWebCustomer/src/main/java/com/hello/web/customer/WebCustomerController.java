package com.hello.web.customer;

import com.hello.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebCustomerController extends WebController {
    @RequestMapping("/con_customer")
    public String con_customer(Map<String, Object> dataMap) {
        dataMap.put("str", "WebCustomerController.con_customer");
        return "/con_customer";
    }

//    @RequestMapping("/con")
//    public String con(Map<String, Object> dataMap) {
//        dataMap.put("str", "WebCustomerController.con");
//        return "/con";
//    }
}

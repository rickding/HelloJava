package com.hello.web.customer;

import com.hello.web.WebController;
import org.springframework.beans.factory.annotation.Autowired;
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

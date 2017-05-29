package com.hello.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 2017/5/29.
 */
@Controller
public class OrderController {
    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String order() {
        System.out.println("OrderController.order called from order");
        return "order";
    }
}

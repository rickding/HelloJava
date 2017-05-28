package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
    	// https://github.com/zavier/springmvc/
    	System.out.println("IndexController.index called from index");
        return "hello";
    }
}

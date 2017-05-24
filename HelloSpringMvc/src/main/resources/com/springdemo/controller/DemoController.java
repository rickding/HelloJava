package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/index")
	public String index() {
		return "demo";
		
		// http://www.cnblogs.com/zawier/p/5605040.html
		// https://github.com/zavier/springmvc/
	}
}

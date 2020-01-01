package com.hello.controller;

import com.hello.annotation.AccessLimited;
import com.hello.annotation.ClientIP;
import com.hello.service.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    HelloBean helloBean;

    @AccessLimited(count = 1)
    @RequestMapping(path="hello/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    public Object hello(@PathVariable String name, @ClientIP String ip) {
        return new HashMap<String, Object>() {{
            put("name", name);
            put("ip", ip);
            put("msg", helloBean.sayHello());
        }};
    }
}

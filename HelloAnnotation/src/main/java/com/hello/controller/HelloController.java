package com.hello.controller;

import com.hello.annotation.AccessLimited;
import com.hello.annotation.ClientIP;
import com.hello.service.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin("http://jext.top")
@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    HelloBean helloBean;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @AccessLimited(count = 1)
    @RequestMapping(path="hello/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    public Object hello(@ClientIP String ip, @PathVariable String name, @RequestParam String gender) {
        return new HashMap<String, Object>() {{
            put("ip", ip);
            put("name", name);
            put("gender", gender);
            put("msg", helloBean.sayHello());
        }};
    }
}

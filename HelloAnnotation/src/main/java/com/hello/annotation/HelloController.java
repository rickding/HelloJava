package com.hello.annotation;

import com.hello.annotation.service.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    HelloBean helloBean;

    @RequestMapping(path="hello/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@PathVariable String name) {
        return String.format("%s, %s", name, helloBean.sayHello());
    }
}

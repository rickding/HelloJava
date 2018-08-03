package com.hello.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/")
public class Controller {
    @Autowired
    private Service service;

    @ResponseBody
    @RequestMapping(value = "/chk/{code}", produces = {"application/json;charset=UTF-8"})
    public Object chk(@PathVariable("code") String code) {
        return service.selectFarm(code);
    }
}

package com.hello.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class ApiController {
    @Autowired
    private DBService dbService;

    @ResponseBody
    @RequestMapping(value = "/chk", produces = {"application/json;charset=UTF-8"})
    public Object chk() {
        return dbService.selectFarm("chk");
    }
}

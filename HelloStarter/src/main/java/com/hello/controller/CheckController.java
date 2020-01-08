package com.hello.controller;


import com.hello.mq.ActiveMqService;
import com.hello.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * 服务检查接口
 * @author Ding
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/")
public class CheckController {
    @Autowired
    private ActiveMqService activeMqService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path="mq", method = {RequestMethod.GET, RequestMethod.POST})
    public Object mq(@RequestAttribute(required = false) String ip, @RequestParam(required = false) String msg) {
        if (StrUtil.isEmpty(msg)) {
            msg = String.format("check mq %s", new Date().toString());
        }
        activeMqService.send(msg);

        final String respMsg = msg;
        return new HashMap<String, Object>() {{
            put("ip", ip);
            put("msg", respMsg);
        }};
    }
}

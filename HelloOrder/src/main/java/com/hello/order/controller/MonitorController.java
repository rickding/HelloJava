package com.hello.order.controller;

import com.hello.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2017/5/29.
 */

@RestController
public class MonitorController {
    @RequestMapping(value = "monitor", method = RequestMethod.GET)
    public String monitor() {
        System.out.println(DateUtil.getHHmmSS() + " Monitor.monitor called from monitor");
        return DateUtil.getHHmmSS() + " Hello from monitor.";
    }
}

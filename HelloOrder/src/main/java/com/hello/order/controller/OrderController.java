package com.hello.order.controller;

import com.hello.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 2017/5/29.
 */
@Controller
public class OrderController {
    private Logger logger = Logger.getLogger(OrderController.class);

    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String order() {
        logger.info(DateUtil.getHHmmSS() + " order");
        return "order";
    }
}

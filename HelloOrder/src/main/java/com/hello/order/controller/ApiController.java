package com.hello.order.controller;

import com.hello.order.job.ChannelOrderSyncJob;
import com.hello.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2017/5/29.
 */

@Controller
@RequestMapping(value="/api")
public class ApiController {
    private Logger logger = Logger.getLogger(ApiController.class);

    @Autowired
    private ChannelOrderSyncJob channelOrderSyncJob;

    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    @ResponseBody
    public String monitor() {
        logger.info(DateUtil.getHHmmSS() + " monitor");

        channelOrderSyncJob.taskStart();

        return DateUtil.getHHmmSS() + " Hello from monitor.";
    }
}

package com.hello.order.controller;

import com.hello.order.job.ChannelOrderSyncJob;
import com.hello.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2017/5/29.
 */

@RestController
public class MonitorController {
    @Autowired
    private ChannelOrderSyncJob channelOrderSyncJob;

    @RequestMapping(value = "monitor", method = RequestMethod.GET)
    public String monitor() {
        System.out.println(DateUtil.getHHmmSS() + " Monitor.monitor called from monitor");

        ChannelOrderSyncJob channelOrderSyncJob = new ChannelOrderSyncJob();
        channelOrderSyncJob.taskStart();

        this.channelOrderSyncJob.taskStart();

        return DateUtil.getHHmmSS() + " Hello from monitor.";
    }
}

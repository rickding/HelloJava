package com.hello.order.job;

import com.hello.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017/5/29.
 */

@Service("channelOrderSyncJob")
public class ChannelOrderSyncJob {
    /**
     * Quartz 定时任务
     */
    public void taskStart() {
        System.out.println(DateUtil.getHHmmSS() + " ChannelOrderSyncJob.taskStart");
    }
}

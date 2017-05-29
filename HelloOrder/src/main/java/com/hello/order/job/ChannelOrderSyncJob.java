package com.hello.order.job;

import com.hello.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017/5/29.
 * 渠道订单同步
 */

@Service("channelOrderSyncJob")
public class ChannelOrderSyncJob extends AbstractJob {
    @Override
    public String getJobName() {
        return "CHANNEL_ORDER_SYNC";
    }

    @Override
    public String getJobGroup() {
        return "basic-order";
    }

    @Override
    public void handle(/*JobConfigVO configVO*/) {
        System.out.println(DateUtil.getHHmmSS() + " ChannelOrderSyncJob.taskStart");
    }
}

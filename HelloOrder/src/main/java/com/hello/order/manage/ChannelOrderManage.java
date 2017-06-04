package com.hello.order.manage;

import com.hello.order.mapper.ext.ChannelOrderMapper2;
import com.hello.order.model.ChannelOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by user on 2017/5/30.
 */

@Service("channelOrderManage")
public class ChannelOrderManage {
    @Resource
    private ChannelOrderMapper2 channelOrderMapper2;

    /**
     * 取渠道订单
     *
     * @return 渠道订单xml数组
     */
    public ChannelOrder[] fetchChannelOrders() {
        if (channelOrderMapper2 != null) {
            List<ChannelOrder> orderList = channelOrderMapper2.selectAll();
            if (null != orderList) {
                ChannelOrder[] orders = new ChannelOrder[orderList.size()];
                return orderList.toArray(orders);
            }
        }
        return null;
    }
}

package com.hello.order.manage;

import com.hello.order.mapper.SystemOrderMapper;
import com.hello.order.model.SystemOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by user on 2017/5/30.
 */

@Service("systemOrderManage")
public class SystemOrderManage {
    @Resource
    private SystemOrderMapper systemOrderMapper;

    /**
     * 解析渠道订单为系统订单
     *
     * @param xml 渠道订单
     * @return 系统订单
     */
    public SystemOrder parseChannelOrder(String xml) {
        return null;
    }
}

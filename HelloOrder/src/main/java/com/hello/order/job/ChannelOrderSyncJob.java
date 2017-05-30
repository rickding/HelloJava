package com.hello.order.job;

import com.hello.order.mapper.ChannelOrderMapper;
import com.hello.order.model.ChannelOrder;
import com.hello.order.model.SystemOrder;
import com.hello.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/5/29.
 * 渠道订单同步
 */

@Service("channelOrderSyncJob")
public class ChannelOrderSyncJob extends AbstractJob {
    @Resource
    public ChannelOrderMapper channelOrderMapper;

    @Override
    public String getJobName() {
        return "CHANNEL_ORDER_SYNC";
    }

    @Override
    public String getJobGroup() {
        return "basic-order";
    }

    /**
     * 同步渠道订单
     */
    @Override
    public void handle(/*JobConfigVO configVO*/) {
        System.out.println(DateUtil.getHHmmSS() + " ChannelOrderSyncJob.handle");

        // 读取渠道订单
        ChannelOrder[] channelOrderList = fetchChannelOrders();
        if (channelOrderList == null || channelOrderList.length <= 0) {
            return;
        }

        // 解析xml
        for (ChannelOrder channelOrder : channelOrderList) {
            SystemOrder order = parseChannelOrder(channelOrder.getSourceContent());

            // 检查是否重复
            if (isDuplicated(order)) {
                continue;
            }

            // 获取商品信息
            fetchProduct(order);

            // 获取价格信息
            fetchPrice(order);

            // 拆单
            SystemOrder[] orderList = divideOrder(order);
            if (orderList == null || orderList.length <= 0) {
                continue;
            }

            // 计算运费
            for(SystemOrder subOrder : orderList) {
                calculateDeliveryFee(subOrder);
            }

            // 保存
            int count = insertOrders(orderList);
            if (count != orderList.length) {
                // 保存失败
            }
        }
    }

    /**
     * 取渠道订单
     * @return 渠道订单xml数组
     */
    private ChannelOrder[] fetchChannelOrders() {
        if (channelOrderMapper != null) {
            List<ChannelOrder> orderList = channelOrderMapper.selectAll();
            if (null != orderList) {
                ChannelOrder[] orders = new ChannelOrder[orderList.size()];
                return orderList.toArray(orders);
            }
        }
        return null;
    }

    /**
     * 解析渠道订单为系统订单
     * @param xml 渠道订单
     * @return 系统订单
     */
    private SystemOrder parseChannelOrder(String xml) {
        return null;
    }

    /**
     * 判断订单是否已经存在于系统订单中
     * @param order，系统订单
     * @return 是否已经存在
     */
    private boolean isDuplicated(SystemOrder order) {
        return false;
    }

    /**
     * 获取商品信息
     * @param order 系统订单
     */
    private void fetchProduct(SystemOrder order) {

    }

    /**
     * 获取价格信息
     * @param order
     */
    private void fetchPrice(SystemOrder order) {

    }

    /**
     * 根据仓库路由拆单
     * @param order 系统订单
     * @return 子订单数组，包含自己。当无须拆单时，返回数组只有自己。
     */
    private SystemOrder[] divideOrder(SystemOrder order) {
        ArrayList<SystemOrder> orderList = new ArrayList<SystemOrder>(1);
        orderList.add(order);

        SystemOrder[] orders = new SystemOrder[orderList.size()];
        return orderList.toArray(orders);
    }

    /**
     * 计算配送费
     * @param order 子订单
     */
    private void calculateDeliveryFee(SystemOrder order) {

    }

    private int insertOrders(SystemOrder[] orderList) {
        return 0;
    }
}

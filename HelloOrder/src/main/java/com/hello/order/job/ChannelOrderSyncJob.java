package com.hello.order.job;

import com.hello.order.manage.ChannelOrderManage;
import com.hello.order.manage.SystemOrderManage;
import com.hello.order.model.ChannelOrder;
import com.hello.order.model.SystemOrder;
import com.hello.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by user on 2017/5/29.
 * 渠道订单同步
 */

@Service("channelOrderSyncJob")
public class ChannelOrderSyncJob extends AbstractJob {
    private Logger logger = Logger.getLogger(ChannelOrderSyncJob.class);

    @Autowired
    private ChannelOrderManage channelOrderManage;

    @Autowired
    private SystemOrderManage systemOrderManage;

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
        logger.info(DateUtil.getHHmmSS() + " handle");

        // 读取渠道订单
        ChannelOrder[] channelOrderList = channelOrderManage.fetchChannelOrders();
        if (channelOrderList == null || channelOrderList.length <= 0) {
            return;
        }

        // 解析xml
        for (ChannelOrder channelOrder : channelOrderList) {
            SystemOrder order = systemOrderManage.parseChannelOrder(channelOrder.getSourceContent());

            // 检查是否为空
            if (null == order) {
                logger.warn("Null order is parsed from " + channelOrder.getSourceContent());
                continue;
            }

            // 检查是否重复
            if (systemOrderManage.isDuplicated(order)) {
                logger.warn("Duplicated order is parsed from " + channelOrder.getSourceContent());

//                continue;

                while (systemOrderManage.isDuplicated(order)) {
                    order.setOrderCode(order.getOrderCode() + "D");
                }
                if (order.getOrderCode().length() >= 255) {
                    continue;
                }
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
            for (SystemOrder subOrder : orderList) {
                calculateDeliveryFee(subOrder);
            }

            // 保存
            int count = systemOrderManage.insertOrders(orderList);
            if (count != orderList.length) {
                // 保存失败
                logger.error(String.format("Fail to save the new orders: %d, actual: %d", orderList.length, count));
            }
        }
    }

    /**
     * 获取商品信息
     *
     * @param order 系统订单
     */
    private void fetchProduct(SystemOrder order) {

    }

    /**
     * 获取价格信息
     *
     * @param order
     */
    private void fetchPrice(SystemOrder order) {

    }

    /**
     * 根据仓库路由拆单
     *
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
     *
     * @param order 子订单
     */
    private void calculateDeliveryFee(SystemOrder order) {

    }
}

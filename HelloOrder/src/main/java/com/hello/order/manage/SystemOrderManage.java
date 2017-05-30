package com.hello.order.manage;

import com.hello.order.mapper.SystemOrderMapper;
import com.hello.order.mapper.ext.SystemOrderMapper2;
import com.hello.order.model.SystemOrder;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by user on 2017/5/30.
 */

@Service("systemOrderManage")
public class SystemOrderManage {
    Logger logger = Logger.getLogger(SystemOrderManage.class);

    @Resource
    private SystemOrderMapper systemOrderMapper;

    @Resource
    private SystemOrderMapper2 systemOrderMapper2;

    /**
     * 解析渠道订单为系统订单
     * @param xml 渠道订单
     * @return 系统订单
     */
    public SystemOrder parseChannelOrder(String xml) {
        if (xml == null || xml.length() <= 0) {
            logger.info("Invalid xml is passed: " + xml);
            return null;
        }

        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        if (doc == null) {
            logger.info("Failed to pass xml: " + xml);
            return null;
        }

        Element ele = doc.getRootElement();
        if (ele == null) {
            logger.info("Invalid xml: " + xml);
            return null;
        }

        SystemOrder obj = new SystemOrder();
        Element x = ele.element("code");
        if (x != null) {
            obj.setOrderCode(x.getTextTrim());
        }

        return obj;

/*        // map xml to object
        ObjectMapper xmlMapper = new XmlMapper();
        try {
            SystemOrder obj = xmlMapper.readValue(xml, SystemOrder.class);
            return obj;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Failed to pass xml: " + xml);
        return null;*/
    }

    /**
     * 判断订单是否已经存在于系统订单中
     * @param order，系统订单
     * @return 是否已经存在
     */
    public boolean isDuplicated(SystemOrder order) {
        if (null == order) {
            logger.info("Invalid order list");
            return false;
        }

        return systemOrderMapper2.countByOrderCode(order.getOrderCode()) > 0;
    }

    /**
     * 创建新订单
     * @param orderList
     * @return
     */
    public int insertOrders(SystemOrder[] orderList) {
        if (orderList == null || orderList.length <= 0) {
            logger.info("Invalid order list");
            return 0;
        }

        int count = 0;
        for (SystemOrder order : orderList) {
            count += systemOrderMapper.insert(order);
        }

        return count;
    }
}

package com.hello.order.mapper.ext;

import com.hello.order.mapper.SystemOrderMapper;
import com.hello.order.model.SystemOrder;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2017/5/30.
 */

@Repository
public interface SystemOrderMapper2 extends SystemOrderMapper{
    int countByOrderCode(String orderCode);
    int insert(SystemOrder record);
}

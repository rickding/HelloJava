package com.hello.order.mapper.ext;

import org.springframework.stereotype.Repository;

/**
 * Created by user on 2017/5/30.
 */

@Repository
public interface SystemOrderMapper2 {
    int countByOrderCode(String orderCode);
}

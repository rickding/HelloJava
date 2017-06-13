package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/6/11.
 */
public class CouponTest {
    @Test
    public void testFindValidLogs() {
        Map<String[], Long> mapIO = new HashMap<String[], Long>() {{
            put(new String[]{}, -1L);
            put(new String[]{"o 1"}, 1L);
            put(new String[]{"?", "o 1"}, -1L);
            put(new String[]{"I 1", "?", "O 1"}, -1L);
            put(new String[]{"i 2", "o 1"}, 2L);
        }};

        for (Map.Entry<String[], Long> io : mapIO.entrySet()) {
            List<String> ar = new ArrayList<String>();
            for (String str : io.getKey()) {
                ar.add(str);
            }

            Assert.assertEquals(
                    io.getValue().longValue(),
                    Coupon.findValidLogs(ar)
            );
        }
    }
}

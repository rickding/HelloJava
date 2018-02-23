package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BinarySubStringTest {
    @Test
    public void testCounting() {
        Map<String, Integer> mapIO = new HashMap<String, Integer>(){{
            put("10001", 2);
            put("10101", 4);
            put("00110", 3);
        }};

        for (Map.Entry<String, Integer> io : mapIO.entrySet()) {
            int ret = BinarySubString.counting(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

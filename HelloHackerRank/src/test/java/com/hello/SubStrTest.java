package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubStrTest {
    @Test
    public void testGetSmallestAndLargest() {
        Map<String, String> mapIO = new HashMap<String, String>() {{
            put("welcometojava", "ava\nwel");
        }};

        for (Map.Entry<String, String> io : mapIO.entrySet()) {
            String ret = SubStr.getSmallestAndLargest(io.getKey(), 3);
            Assert.assertEquals(io.getValue(), ret);
        }
    }
}

package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubStrTest {
    @Test
    public void testSplitTokens() {
        Map<String, Integer> mapIO = new HashMap<String, Integer>() {{
            put("He is a very very good boy, isn't he?", 10);
            put("           YES      leading spaces        are valid,    problemsetters are         evillllll", 8);
        }};

        for (Map.Entry<String, Integer> io : mapIO.entrySet()) {
            String[] ret = SubStr.splitTokens(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret == null ? 0 : ret.length);
        }
    }

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

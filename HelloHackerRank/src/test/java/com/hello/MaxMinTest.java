package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxMinTest {
    @Test
    public void testMaxMin() {
        Map<Object[], long[]> pairIO = new HashMap<Object[], long[]>() {{
            put(new Object[] {new String[]{"push", "push", "push", "pop"}, new int[]{1, 2, 3, 1}}, new long[]{1, 2, 3, 6});
            put(new Object[] {new String[]{"push", "push"}, new int[] {3, 2}}, new long[]{9, 6});
        }};

        for (Map.Entry<Object[], long[]> io : pairIO.entrySet()) {
            long[] ret = MaxMin.maxMin((String[])io.getKey()[0], (int[])io.getKey()[1]);
            Assert.assertArrayEquals(io.getValue(), ret);
        }
    }
}

package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindMaxTest {
    @Test
    public void testFindMax() {
        Map<String, int[]> mapIO = new HashMap<String, int[]>() {{
            put("3 4 5 1 3 # 1", new int[]{6, 9});
            put("3 2 3 # 3 # 1", new int[]{5, 7});
        }};

        for (Map.Entry<String, int[]> io : mapIO.entrySet()) {
            long ret = FindMax.findMax(io.getValue()[0], io.getKey());
            Assert.assertEquals((long)(io.getValue()[1]), ret);
        }

//        long ret = Hello.findMax(new Long[]{3L, 9L, 5L}, 0);
//        Assert.assertEquals(9, ret);
    }
}

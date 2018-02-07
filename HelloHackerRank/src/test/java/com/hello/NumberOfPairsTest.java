package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsTest {
    @Test
    public void testBraces() {
        Map<int[], Integer[]> mapIO = new HashMap<int[], Integer[]>() {{
//            put(new int[] {1, 3, 46, 1, 3, 9}, new Integer[]{47, 1});
            put(new int[] {6, 6, 3, 9, 3, 5, 1}, new Integer[]{12, 2});
        }};
        for (Map.Entry<int[], Integer[]> io : mapIO.entrySet()) {
            Integer ret = NumberOfPairs.numberOfPairs(io.getKey(), io.getValue()[0]);
            Assert.assertEquals(io.getValue()[1], ret);
        }
    }
}

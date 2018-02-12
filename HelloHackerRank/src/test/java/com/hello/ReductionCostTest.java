package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReductionCostTest {
    @Test
    public void testReductionCost() {
        Map<int[], Integer> mapIO = new HashMap<int[], Integer>() {{
            put(new int[] {1, 2, 3}, 9);
            put(new int[] {1, 2, 3, 4}, 19);
        }};

        for (Map.Entry<int[], Integer> io : mapIO.entrySet()) {
            int ret = ReductionCost.reductionCost(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceCapacityTest {
    @Test
    public void testHowManyAgentsToAdd() {
        Map<int[][], int[]> mapIO = new HashMap<int[][], int[]>(){{
            put(new int[][] {{1481122000, 1481122020}, {1481122000, 1481122040}, {1481122030, 1481122035}}, new int[]{1, 1});
        }};

        for (Map.Entry<int[][], int[]> io : mapIO.entrySet()) {
            int ret = CustomerServiceCapacity.howManyAgentsToAdd(io.getValue()[0], io.getKey());
            Assert.assertEquals(io.getValue()[1], ret);
        }
    }
}

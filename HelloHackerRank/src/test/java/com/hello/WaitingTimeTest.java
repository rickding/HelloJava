package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WaitingTimeTest {
    @Test
    public void testWaitingTime() {
        Map<int[], long[]> mapIO = new HashMap<int[], long[]>(){{
            put(new int[]{2, 6, 3, 4, 5}, new long[]{2, 12});
            put(new int[]{1, 1, 1, 1}, new long[]{0, 1});
            put(new int[]{5, 5, 2, 3}, new long[]{3, 11});
        }};

        for(Map.Entry<int[], long[]> io : mapIO.entrySet()) {
            long ret = WaitingTime.waitingTime(io.getKey(), (int)io.getValue()[0]);
            Assert.assertEquals(io.getValue()[1], ret);
        }
    }
}

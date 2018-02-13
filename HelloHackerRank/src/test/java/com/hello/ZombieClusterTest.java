package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ZombieClusterTest {
    @Test
    public void testZombieCluster() {
        Map<String[], Integer> mapIO = new HashMap<String[], Integer>() {{
            put(new String[]{"10000", "01000", "00100", "00010", "00001"}, 5);
            put(new String[]{"1100", "1110", "0110", "0001"}, 2);
        }};

        for (Map.Entry<String[], Integer> io : mapIO.entrySet()) {
            int ret = ZombieCluster.zombieCluster(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

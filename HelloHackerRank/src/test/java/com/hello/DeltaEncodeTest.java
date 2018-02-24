package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DeltaEncodeTest {
    @Test
    public void testDeltaEncode() {
        Map<int[], int[]> mapIO = new HashMap<int[], int[]>(){{
            put(new int[]{25626, 25757, 24367, 24267, 16, 100, 2, 7277}, new int[]{25626, -128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128, 7275});
        }};

        for (Map.Entry<int[], int[]> io : mapIO.entrySet()) {
            int[] ret = DeltaEncode.delta_encode(io.getKey());
            Assert.assertArrayEquals(io.getValue(), ret);
        }
    }
}

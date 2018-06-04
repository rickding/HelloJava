package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CutSticksTest {
    @Test
    public void testCutSticks() {
        Map<int[], int[]> mapIO = new HashMap<int[], int[]>() {{
            put(new int[]{1, 1, 2, 3}, new int[]{4, 2, 1});
            put(new int[]{5, 4, 4, 2, 2, 8}, new int[]{6, 4, 2, 1});
        }};

        for (Map.Entry<int[], int[]> io : mapIO.entrySet()) {
            int[] ret = CutSticks.cutSticks(io.getKey());
            Assert.assertArrayEquals(io.getValue(), ret);
        }
    }
}

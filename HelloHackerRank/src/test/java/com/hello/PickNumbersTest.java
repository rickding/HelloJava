package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PickNumbersTest {
    @Test
    public void testPickNumbers() {
        Map<int[], Integer> mapIO = new HashMap<int[], Integer>() {{
            put(null, 0);
            put(new int[]{4, 6, 5, 3, 3, 1}, 3);
            put(new int[]{1, 2, 2, 3, 1, 2}, 5);
            put(new int[]{
                    4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9,
                    9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2,
                    3, 98, 98, 1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2, 1, 1, 9, 2, 4},
                    22);
        }};

        for (Map.Entry<int[], Integer> io : mapIO.entrySet()) {
            int ret = PickNumbers.pickNumbers(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

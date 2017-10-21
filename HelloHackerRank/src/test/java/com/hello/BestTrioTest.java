package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
5 6
1 2
1 3
2 3
2 4
3 4
4 5
2

7 4
2 1
3 6
5 1
1 7
-1
*/
public class BestTrioTest {
    @Test
    public void testBestTrio() {
        Map<Object[], Integer> mapIO = new HashMap<Object[], Integer>() {{
            put(new Object[]{5, new int[]{1, 1, 2, 2, 3, 4}, new int[]{2, 3, 3, 4, 4, 5}}, 2);
            put(new Object[]{7, new int[]{2, 3, 5, 1}, new int[]{1, 6, 1, 7}}, -1);
        }};

        for (Map.Entry<Object[], Integer> io : mapIO.entrySet()) {
            int ret = BestTrio.bestTrio((Integer) io.getKey()[0], (int[]) io.getKey()[1], (int[]) io.getKey()[2]);
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

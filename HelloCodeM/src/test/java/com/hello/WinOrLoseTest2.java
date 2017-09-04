package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017/6/11.
 */
public class WinOrLoseTest2 {
    @Test
    public void testWinOrLose() {
        Map<Integer, int[]> mapIO = new HashMap<Integer, int[]>() {{
            put(0, new int[] {2, 3});
            put(1, new int[] {5, 3});
        }};

        for (Map.Entry<Integer, int[]> io : mapIO.entrySet()) {
            Assert.assertEquals(
                    io.getKey().intValue(),
                    WinOrLose2.winOrLose(io.getValue()[0], io.getValue()[1])
            );
        }
    }

    @Test
    public void testCalculateLoop() {
        Map<long[], Integer> mapIO = new HashMap<long[], Integer>() {{
            put(new long[] {7, 1, 2, 3, 1, 3, 1, 2, 5, 6, 1, 6, 2, 5}, 0);

            put(new long[] {4, 1}, 1);
            put(new long[] {1000000, 1, 2, -1000000}, 2);
            put(new long[] {4, 1, 2, 3, 1, 3, 1, 2}, 3);
            put(new long[] {7, 1, 2, 3, 1, 3, 1, 2, 5, 6, 1, 6, 2, 5, 3, 6}, 4);

            // From the question
            put(new long[] {4, 1, 2, 3}, 2);

            // From new coder
            put(new long[] {-5, -3, 1, 0, 2, -6, -4, -6}, 1);
            put(new long[] {-10, 6, -6, -2}, 0);
//            put(new long[] {6, 0, -8, 8, -2, 3, 0, 3, -4, 2, 1, -6, -2, 4, -7, -7}, 3);
        }};

        for (Map.Entry<long[], Integer> io : mapIO.entrySet()) {
            long[] ar = io.getKey();
            ArrayList<Long> list = new ArrayList<Long>(ar.length);
            for (long item : ar) {
                list.add(item);
            }

            Assert.assertEquals(
                    io.getValue().intValue(),
                    WinOrLose2.calculateLoop(list)
            );
        }
    }
}

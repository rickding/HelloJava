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
        Map<Integer, long[]> mapIO = new HashMap<Integer, long[]>() {{
            put(0, new long[] {7, 1, 2, 3, 1, 3, 1, 2, 5, 6, 1, 6, 2, 5});
            put(1, new long[] {4, 1});
            put(2, new long[] {1000000, 1, 2, -1000000});
            put(3, new long[] {4, 1, 2, 3, 1, 3, 1, 2});
            put(4, new long[] {7, 1, 2, 3, 1, 3, 1, 2, 5, 6, 1, 6, 2, 5, 3, 6});
        }};

        for (Map.Entry<Integer, long[]> io : mapIO.entrySet()) {
            long[] ar = io.getValue();
            ArrayList<Long> list = new ArrayList<Long>(ar.length);
            for (long item : ar) {
                list.add(item);
            }

            Assert.assertEquals(
                    io.getKey().intValue(),
                    WinOrLose2.calculateLoop(list)
            );
        }
    }
}

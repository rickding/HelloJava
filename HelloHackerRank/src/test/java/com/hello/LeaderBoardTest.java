package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoardTest {
    @Test
    public void testGetRanks() {
        Map<List<int[]>, int[]> ioMap = new HashMap<List<int[]>, int[]>() {{
            put(new ArrayList() {{
                add(new int[] {100, 100, 50, 40, 40, 20, 10});
                add(new int[] {5, 25, 50, 120});
            }}, new int[] {6, 4, 2, 1});
        }};

        for (Map.Entry<List<int[]>, int[]> io : ioMap.entrySet()) {
            int[] ranks = LeaderBoard.getRanks(io.getKey().get(0), io.getKey().get(1));
            Assert.assertArrayEquals(ranks, io.getValue());
        }
    }
}

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
public class WinOrLoseTest {
    @Test
    public void testWinOrLose() {
        Map<Integer, Long[]> mapIO = new HashMap<Integer, Long[]>() {{
            put(0, new Long[]{new Long("2"), new Long("3")});
            put(1, new Long[]{new Long("5"), new Long("3")});
        }};

        for (Map.Entry<Integer, Long[]> io : mapIO.entrySet()) {
            Assert.assertEquals(
                    io.getKey().intValue(),
                    WinOrLose.winOrLose(io.getValue()[0], io.getValue()[1])
            );
        }
    }
}

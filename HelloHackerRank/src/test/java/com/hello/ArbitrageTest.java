package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class ArbitrageTest {
    @Test
    public void testArbitrage() {
        int[] ret = Arbitrage.arbitrage(new String[]{"1.1837 1.3829 0.6102", "1.1234 1.2134 1.2311"});
        Assert.assertArrayEquals(new int[]{114, 0}, ret);
    }
}

package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class HelloTest {
    @Test
    public void testFindMax() {
        long ret = Hello.findMax(6, "3 4 5 1 3 # 1");
        Assert.assertEquals(9, ret);

//        long ret = Hello.findMax(new Long[]{3L, 9L, 5L}, 0);
//        Assert.assertEquals(9, ret);
    }

    @Test
    public void testElectionWinner() {
        String ret = Hello.electionWinner(null);
        Assert.assertEquals(null, ret);
    }

    @Test
    public void testMain() {
        Hello.main(null);
    }

    @Test
    public void testArbitrage() {
        int[] ret = Hello.arbitrage(new String[]{"1.1837 1.3829 0.6102", "1.1234 1.2134 1.2311"});
        Assert.assertArrayEquals(new int[]{114, 0}, ret);
    }
}

package com.hello;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxTest {
    @Test
    public void testFindMax() {
        long ret = FindMax.findMax(6, "3 4 5 1 3 # 1");
        Assert.assertEquals(9, ret);

//        long ret = Hello.findMax(new Long[]{3L, 9L, 5L}, 0);
//        Assert.assertEquals(9, ret);
    }
}

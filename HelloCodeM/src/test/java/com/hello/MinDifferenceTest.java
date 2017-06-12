package com.hello;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for MinDifference.
 */
public class MinDifferenceTest {
    @Test
    public void testGetMinDifference() {
        int n = 2, m = 4;
        int[] arA = {1, 2}, arB = {3, 1, 2, 4};

        Assert.assertEquals(0, MinDifference.getMinDifference(arA, n, arB, m));
    }

    @Test
    public void testGetMinDifference2() {
        int n = 2, m = 4;
        int[] arA = {1, 2}, arB = {1, 4, 2, 3};

        Assert.assertEquals(2, MinDifference.getMinDifference(arA, n, arB, m));
    }
}

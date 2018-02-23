package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PermutationEquationTest {
    @Test
    public void testPermutationEquation() {
        Map<int[], int[]> mapIO = new HashMap<int[], int[]>(){{
            put(new int[]{2, 3, 1}, new int[] {2, 3, 1});
        }};

        for (Map.Entry<int[], int[]> io : mapIO.entrySet()) {
            int[] ret = PermutationEquation.permutationEquation(io.getKey());
            Assert.assertArrayEquals(io.getValue(), ret);
        }
    }
}

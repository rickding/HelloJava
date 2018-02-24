package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TriangleTest {
    @Test
    public void testTriangle() {
        Map<int[], Integer> mapIO = new HashMap<int[], Integer>() {{
            put(new int[]{3, 3, 3}, 1);
            put(new int[]{3, 5, 4}, 2);
        }};

        for (Map.Entry<int[], Integer> io : mapIO.entrySet()) {
            int[] i = io.getKey();
            int ret = Triangle.triangle(i[0], i[1], i[2]);
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }

    @Test
    public void testTriangleOrNot() {
        int[] a = {7, 10, 7};
        int[] b = {2, 3, 4};
        int[] c = {2, 7, 4};

        String[] results = Triangle.triangleOrNot(a, b, c);
        System.out.println(Arrays.asList(results));
    }
}

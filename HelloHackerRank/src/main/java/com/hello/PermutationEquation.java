package com.hello;

import java.util.HashMap;
import java.util.Map;

public class PermutationEquation {
    public static int[] permutationEquation(final int[] p) {
        if (p == null || p.length <= 0) {
            return null;
        }

        // Generate the map
        Map<Integer, Integer> equationMap = new HashMap<Integer, Integer>(){{
            for (int i = 0; i < p.length; i++) {
                put(p[i], i + 1);
            }
        }};

        // Find the values
        int[] arr = new int[p.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = equationMap.get(equationMap.get(i + 1));
        }
        return arr;
    }
}

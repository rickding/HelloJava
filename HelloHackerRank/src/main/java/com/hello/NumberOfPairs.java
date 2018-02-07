package com.hello;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs {
/*
 * Complete the function below.
 */
    static int numberOfPairs(int[] a, long k) {
        if (a == null || a.length <= 1) {
            return 0;
        }

        Arrays.sort(a);
        Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            int m = a[i];
            for (int j = a.length - 1; j > i; j--) {
                int n = a[j];
                if (m + n < k) {
                    break;
                } else if (m + n == k) {
                    pairMap.put(m, n);
                }
            }
        }
        return pairMap.size();
    }
}

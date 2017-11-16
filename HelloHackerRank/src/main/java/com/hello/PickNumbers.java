package com.hello;

import java.util.Arrays;

public class PickNumbers {
    public static int pickNumbers(int[] ar) {
        if (ar == null || ar.length <= 0) {
            return 0;
        }

        Arrays.sort(ar);
        int n = ar.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int diff = 0;
            for (int j = i - 1; j >= 0; j--) {
                int tmp = Math.abs(ar[i] - ar[j]);
                if (tmp <= 1) {
                    count++;

                    if (diff < tmp) {
                        diff = tmp;
                    }
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                int tmp = Math.abs(ar[i] - ar[j]);
                if (diff + tmp <= 1) {
                    count++;
                } else {
                    break;
                }
            }

            if (max < count) {
                max = count;
            }
        }

        return max + 1;
    }
}

package com.hello;

import java.util.Arrays;

public class ReductionCost {
    public static int reductionCost(int[] numArr) {
        if (numArr == null || numArr.length <= 0) {
            return 0;
        }

        int cost = 0;
        for (int i = 0; i < numArr.length - 1; i++) {
            // Sort ascending
            Arrays.sort(numArr);

            // Pickup the smallest two ones
            int sum = numArr[i] + numArr[i + 1];

            numArr[i] = 0;
            numArr[i + 1] = sum;
            cost += sum;
        }

        return cost;
    }
}

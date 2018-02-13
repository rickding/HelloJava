package com.hello;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    public static long findMax(int n, String tree) {
        if (n <= 0 || tree == null || tree.trim().length() <= 0) {
            return 0;
        }

        // Split the nodes
        String[] nodes = tree.trim().split(" ");
        if (nodes.length < n) {
            return 0;
        }

        // Count the nodes
        List<Long> sumList = new ArrayList<Long>();
        int countExpected = 1;
        int count = 0;
        int index = 0;
        long sum = 0;
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (!node.equals("#")) {
                count++;
                sum += Long.valueOf(node);
            }
            index++;

            // Check if next level starts
            if (index >= countExpected) {
                sumList.add(sum);
                countExpected = (int)Math.pow(2, count);

                count = 0;
                index = 0;
                sum = 0;
            }
        }

        // Find the max sum
        Long[] sumArr = new Long[sumList.size()];
        sumList.toArray(sumArr);
        return findMax(sumArr, 0);
    }

    static long findMax(Long[] sumArr, int startIndex) {
        if (sumArr == null || sumArr.length <= startIndex || startIndex < 0) {
            return 0;
        }

        // Find the max sum
        long max = 0;
        for (int i = startIndex; i < sumArr.length; i++) {
            // Itself
            long sum = sumArr[i];
            if (max < sum) {
                max = sum;
            }

            // Plus later ones
            for (int j = i + 2; j < sumArr.length; j++) {
                sum = sumArr[i] + findMax(sumArr, j);
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }
}

package com.hello;

import java.util.Scanner;

/**
 * Minimum difference
 */
public class MinDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arA = new int[n];
        for (int i = 0; i < n; i++) {
            arA[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arB = new int[m];
        for (int j = 0; j < m; j++) {
            arB[j] = sc.nextInt();
        }

        sc.close();

        System.out.println(getMinDifference(arA, n, arB, m));
    }

    /**
     * Find the minimum difference: = SUM(a[i] - b[i])2 (1 ≤ i ≤ n)
     * @param arA
     * @param n
     * @param arB
     * @param m
     * @return
     */
    public static int getMinDifference(int[] arA, int n, int[] arB, int m) {
        if (n <= 0 || n > m || n != arA.length || m != arB.length) {
            return 0;
        }

        // Loop to calculate
        int minDiff = Integer.MAX_VALUE;
        for (int j = n - 1; j < m; j++) {
            int diff = 0;
            for (int i = 0; i < n; i++) {
                int tmp = arA[i] - arB[j - n + 1 + i];
                diff += tmp * tmp;
            }

            // Compare
            if (minDiff > diff) {
                minDiff = diff;
            }

            if (minDiff == 0) {
                break;
            }
        }

        // Exception
        if (minDiff == Integer.MAX_VALUE) {
            minDiff = 0;
        }

        return minDiff;
    }
}

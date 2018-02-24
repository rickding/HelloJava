package com.hello;

/**
 * Created by user on 2017/8/1.
 */
public class Triangle {
    public static int triangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 0;
        }

        // If sum of any two edges is greater than the length of the third edge
        if (a == b && b == c) {
            return 1;
        } else if (a + b > c && b + c > a && a + c > b) {
            return 2;
        }
        return 0;
    }

    public static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null || a.length != b.length || a.length != c.length) {
            return null;
        }

        final int count = a.length;
        String[] results = new String[count];
        for (int i = 0; i < count; i++) {
            if (triangle(a[i], b[i], c[i]) > 0) {
                results[i] = "Yes";
            } else {
                results[i] = "No";
            }
        }
        return results;
    }
}

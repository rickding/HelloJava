package com.hello;

/**
 * Created by user on 2017/8/1.
 */
public class Triangle {
    public static void main(String[] args) {
        int[] a = {7, 10, 7};
        int[] b = {2, 3, 4};
        int[] c = {2, 7, 4};

        String[] results = triangleOrNot(a, b, c);
        System.out.println(results);
    }

    public static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        if (a == null || b == null || c == null || a.length != b.length || a.length != c.length) {
            return null;
        }

        final int count = a.length;
        String[] results = new String[count];
        for (int i = 0; i < count; i++) {
            int l = a[i], m = b[i], n = c[i];
            if (l + m > n && l + n > m && m + n > l) {
                results[i] = "Yes";
            } else {
                results[i] = "No";
            }
        }
        return results;
    }
}

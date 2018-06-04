package com.hello;

public class SubStr {
    public static String getSmallestAndLargest(String str, int k) {
        if (str == null || str.length() < k || k <= 0) {
            return "\n";
        }

        String smallest = str.substring(0, k);
        String largest = smallest;

        // Loop to check
        for (int i = 1; i < str.length() - k + 1; i++) {
            String sub = str.substring(i, i + k);
            if (smallest.compareTo(sub) > 0) {
                smallest = sub;
            }

            if (largest.compareTo(sub) < 0) {
                largest = sub;
            }
        }
        return smallest + "\n" + largest;
    }
}

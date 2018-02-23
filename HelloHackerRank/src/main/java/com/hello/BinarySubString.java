package com.hello;

public class BinarySubString {
    public static int counting(String s) {
        if (s == null || s.trim().length() <= 1) {
            return 0;
        }

        // Convert to char array
        char[] arr = s.trim().toCharArray();
        int len = arr.length;

        // Loop to find
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                count++;

                // Extend to find more
                int m = i - 1;
                int n = i + 1 + 1;
                while (m >= 0 && n < len && arr[i] == arr[m] && arr[i + 1] == arr[n]) {
                    count++;
                    m--;
                    n++;
                }
            }
        }
        return count;
    }
}

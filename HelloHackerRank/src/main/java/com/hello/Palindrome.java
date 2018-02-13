package com.hello;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Palindrome {
    static int getScore(String s) {
        if (s == null || s.trim().length() <= 1) {
            return 0;
        }

        // Special cases
        if (s.length() == 2) {
            return 1;
        }

        // Loop to check
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            String p1 = getMaxPalindrome(s.substring(0, i));
            String p2 = getMaxPalindrome(s.substring(i, s.length()));
            int tmp = (p1 == null ? 0 : p1.length()) * (p2 == null ? 0 : p2.length());
            if (score < tmp) {
                score = tmp;
            }
        }
        return score;
    }

    /**
     * Select the max one from the possible palindromes
     * @param s
     * @return
     */
    static String getMaxPalindrome(String s) {
        String[] arr = getPalindromes(s);
        if (arr == null || arr.length <= 0) {
            return null;
        }

        // Find the max one
        String str = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (str.length() < arr[i].length()) {
                str = arr[i];
            }
        }
        return str;
    }

    /**
     * Return the possible palindromes
     * @param s
     * @return
     */
    static String[] getPalindromes(String s) {
        if (s == null || s.trim().length() <= 0) {
            return null;
        }

        // Compare the char
        s = s.trim();
        int m = 0;
        int n = s.length() - 1;
        if (m == n) {
            return new String[]{s};
        }

        // Left moves, right moves
        Set<String> set = new HashSet<String>();
        String[] arr = getPalindromes(s.substring(m + 1, n));
        if (s.charAt(m) != s.charAt(n) && arr != null) {
            set.addAll(Arrays.asList(arr));
        } else if (s.charAt(m) == s.charAt(n)) {
            // Keep the same chars
            if (arr != null) {
                for (String tmp : arr) {
                    set.add(String.format("%c%s%c", s.charAt(m), tmp, s.charAt(n)));
                }
            } else {
                set.add(String.format("%c%c", s.charAt(m), s.charAt(n)));
            }
        }

        // Left moves, right keep
        arr = getPalindromes(s.substring(m + 1, n + 1));
        if (arr != null) {
            set.addAll(Arrays.asList(arr));
        }

        // Left keep, right moves
        arr = getPalindromes(s.substring(m, n));
        if (arr != null) {
            set.addAll(Arrays.asList(arr));
        }

        // Return the found ones
        arr = new String[set.size()];
        set.toArray(arr);
        return arr;
    }
}

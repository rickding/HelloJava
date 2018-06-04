package com.hello;

public class Anagram {
    public static boolean isAnagram(String strA, String strB) {
        if (strA == null || strA.length() <= 0 || strB == null || strA.length() != strB.length()) {
            return false;
        }

        // Count the first string
        int[] countArr = new int[26];
        for (char c : strA.toLowerCase().toCharArray()) {
            countArr[c - 'a']++;
        }

        // Minus the second string
        for (char c : strB.toLowerCase().toCharArray()) {
            countArr[c - 'a']--;
        }

        // Check if it's 0
        for (int v : countArr) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}

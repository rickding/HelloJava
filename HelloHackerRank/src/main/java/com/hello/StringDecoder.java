package com.hello;

/**
 * Created by user on 2017/8/1.
 */
public class StringDecoder {
    public static void main(String[] args) {
        String str = "1226#24#";
        int[] frequencies = frequency(str);
        System.out.println(frequencies);
    }

    private static void addFrequency(int[] chars, int c) {
        if (chars != null && c >= 0 && c < chars.length) {
            chars[c]++;
        }
    }

    static int[] frequency(String s) {
        int[] chars = new int[26];
        if (s == null || s.length() <= 0) {
            return chars;
        }

        int i = 0;
        final int count = s.length();
        final char SYMBOL = '#';
        while (i < count) {
            char c = s.charAt(i);
            if (c >= '3' && c <= '9') {
                // parse directly
                addFrequency(chars, c - '1');

                // next one
                i++;
            } else if (c >= '1' && c <= '2') {
                // check if it is greater or equal than 10#
                boolean isDouble = false;
                if (i + 2 < count && s.charAt(i + 2) == SYMBOL) {
                    String subStr = s.substring(i, i + 2);
                    addFrequency(chars, Integer.valueOf(subStr) - 1);

                    // next one, pass two and symbol
                    i += 3;
                } else {
                    // parse the one
                    addFrequency(chars, c - '1');

                    // next one
                    i++;
                }
            } else {
                System.out.printf("Error in str, %c", c);

                // next one
                i++;
            }
        }

        return chars;
    }
}

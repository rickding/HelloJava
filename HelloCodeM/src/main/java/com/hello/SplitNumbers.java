package com.hello;

import java.math.BigInteger;
import java.util.List;

public class SplitNumbers {
    public static boolean splitStr(String str, int index, List<BigInteger> numbers) {
        // check the parameters firstly
        if (index >= str.length()) {
            return numbers.size() >= 2;
        }

        if (index < 0 || str.charAt(index) == '0') {
            return false;
        }

        // Loop to find the numbers
        BigInteger offset = new BigInteger("-1");
        for (int i = index; i < str.length(); i++) {
            if (numbers.size() == 0 && i >= str.length() / 2) {
                break;
            }

            BigInteger tmp = new BigInteger(str.substring(index, i + 1));

            // It's the first number or the expected one
            if (numbers.size() == 0 || tmp.add(offset).equals(numbers.get(numbers.size() - 1))) {
                numbers.add(tmp);

                // Find the left string
                if (splitStr(str, i + 1, numbers)) {
                    // Finish the loop
                    return true;
                } else {
                    // Revert the last number, and continue to find
                    numbers.remove(numbers.size() - 1);
                }
            } else if (tmp.add(offset).compareTo(numbers.get(numbers.size() - 1)) >= 0) {
                // The number can't match the rules.
                break;
            }
        }

        // No proper numbers
        return false;
    }
}

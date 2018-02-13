package com.hello;

import java.util.HashMap;
import java.util.Map;

public class Braces {
    static String[] braces(String[] values) {
        if (values == null || values.length <= 0) {
            return null;
        }

        // Define the expected brace map
        Map<Integer, Integer> braceMap = new HashMap<Integer, Integer>() {{
            put((int)')', (int)'(');
            put((int)']', (int)'[');
            put((int)'}', (int)'{');
        }};

        // Loop to check
        String[] ret = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];

            // Check the braces array
            char[] braceArr = new char[value.length() / 2 + 1];
            int j = -1;
            boolean closed = true;
            for (char c : value.toCharArray()) {
                // Right
                if (braceMap.keySet().contains((int)c)) {
                    if (j >= 0 && braceArr[j] == braceMap.get((int)c)) {
                        j--;
                    } else {
                        closed = false;
                        break;
                    }
                } else {
                    // Left
                    if (j < braceArr.length) {
                        ++j;
                        braceArr[j] = c;
                    } else {
                        closed = false;
                        break;
                    }
                }
            }

            // Mark the result
            ret[i] = j < 0 && closed ? "YES" : "NO";
        }
        return ret;
    }
}

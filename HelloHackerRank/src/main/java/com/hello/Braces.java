package com.hello;

import java.util.HashMap;
import java.util.Map;

public class Braces {
    /*
     * Complete the function below.
     */
    static String[] braces(String[] values) {
        if (values == null || values.length <= 0) {
            return null;
        }

        Map<Integer, Integer> braceMap = new HashMap<Integer, Integer>() {{
            put((int)')', (int)'(');
            put((int)']', (int)'[');
            put((int)'}', (int)'{');
        }};

        String[] ret = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String value = values[i];

            char[] braceArr = new char[value.length() / 2 + 1];
            int j = -1;
            for (char c : value.toCharArray()) {
                // Right
                if (braceMap.keySet().contains((int)c)) {
                    if (j >= 0 && braceArr[j] == braceMap.get((int)c)) {
                        j--;
                    } else {
                        break;
                    }
                } else {
                    // Left
                    if (j < braceArr.length) {
                        ++j;
                        braceArr[j] = c;
                    } else {
                        break;
                    }
                }
            }
            ret[i] = j < 0 ? "YES" : "NO";
        }
        return ret;
    }
}

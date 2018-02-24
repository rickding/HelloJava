package com.hello;

import java.util.ArrayList;
import java.util.List;

public class DeltaEncode {
    public static int[] delta_encode(final int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        // Add the first value
        List<Integer> encode = new ArrayList<Integer>(){{
            add(array[0]);
        }};

        // Loop to encode
        for (int i = 1; i < array.length; i++) {
            int diff = array[i] - array[i - 1];
            if (diff < -127 || diff > 127) {
                // Add the escape token
                encode.add(-128);
            }

            // Save the difference
            encode.add(diff);
        }

        // Convert to expected return type
        int[] encodeArr = new int[encode.size()];
        for (int i = 0; i < encode.size(); i++) {
            encodeArr[i] = encode.get(i);
        }
        return encodeArr;
    }
}

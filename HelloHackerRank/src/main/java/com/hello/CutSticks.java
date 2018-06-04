package com.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutSticks {
    public static int[] cutSticks(int[] lengths) {
        if (lengths == null || lengths.length <= 0) {
            return null;
        }

        // Sort firstly
        Arrays.sort(lengths);

        // Initial the count
        int index = 0, count = lengths.length;
        List<Integer> countList = new ArrayList<Integer>();

        // Loop to find the minimum values
        while (index < count) {
            countList.add(count - index);
            if (index == count - 1) {
                break;
            }

            int value = lengths[index];
            for (int i = index + 1; i < count; i++) {
                if (lengths[i] != value || i == count - 1) {
                    // Remember the left count
                    index = i;

                    // Cut the length
                    for (int j = i; j < count; j++) {
                        lengths[j] -= value;
                    }
                    break;
                }
            }
        }

        // Return arr
        int[] arr = new int[countList.size()];
        for (int i = 0; i < countList.size(); i++) {
            arr[i] = countList.get(i);
        }
        return arr;
    }
}

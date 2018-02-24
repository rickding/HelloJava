package com.hello;

public class MaxMin {
    public static long[] maxMin(String[] operations, int[] values) {
        if (operations == null || values == null || operations.length > values.length) {
            return null;
        }

        long[] products = new long[operations.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] arr = new int[operations.length];
        int index = 0;
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            int v = values[i];

            if ("push".equalsIgnoreCase(op)) {
                // Push
                arr[index++] = v;

                // Compare the new value
                if (max < v) {
                    max = v;
                }
                if (min > v) {
                    min = v;
                }
            } else if ("pop".equalsIgnoreCase(op)) {
                // Pop, remove
                for (int j = 0; j < index; j++) {
                    if (arr[j] == v) {
                        for (int k = j + 1; k < index; k++) {
                            arr[k - 1] = arr[k];
                        }
                        arr[index--] = 0;
                        break;
                    }
                }

                // Find the new ones
                if (max == v || min == v) {
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                    for (int j = 0; j <= index; j++) {
                        v = arr[j];
                        if (max < v) {
                            max = v;
                        }
                        if (min > v) {
                            min = v;
                        }
                    }
                }
            }
            products[i] = max * min;
        }
        return products;
    }
}

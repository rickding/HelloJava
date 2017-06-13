package com.hello;

import java.util.*;

/**
 * Created by user on 2017/6/13.
 */
public class Coupon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long n = sc.nextLong();
            List<String> ar = new ArrayList<String>(1024);

            // Scan the input values
            while (n-- > 0 && sc.hasNext()) {
                ar.add(sc.next());
            }

            String[] logs = new String[ar.size()];
            logs = ar.toArray(logs);
            System.out.println(findValidLogs(logs));
        }

    }

    public static long findValidLogs(String[] logs) {
        if (logs == null || logs.length <= 0) {
            return -1;
        }

        // Analyse the logs. If the coupon enters firstly and comes later, it's right.
        long index = 0;
        long freeErrors = 0;
        HashMap<Long, String> map = new HashMap<Long, String>();

        for (String log : logs) {
            index++;

            // Invalid value
            if (log == null || log.length() <= 0) {
                break;
            }

            // Wrong value
            String[] values = log.split(" ");
            if (values == null) {
                break;
            }

            if (values.length == 1) {
                if ("?".equals(values[0])) {
                    freeErrors++;
                    continue;
                } else {
                    break;
                }
            }

            // Check the coupon
            String value = values[0];
            Long key = -1L;

            try {
                key = Long.valueOf(values[1]);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            if (map.containsKey(key)) {
                // If coupon exists, but it's I, then it's wrong.
                if ("i".equalsIgnoreCase(value)) {
                    if (freeErrors-- <= 0) {
                        break;
                    }
                } else {
                    map.remove(key);
                }
            } else {
                // If coupon doesn't exist, but it's O, then it's wrong.
                if ("o".equalsIgnoreCase(value)) {
                    if (freeErrors-- <= 0) {
                        break;
                    }
                } else {
                    map.put(key, value);
                }
            }
        }

        if (index >= logs.length && freeErrors >= 0) {
            index = -1;
        }

        return index;
    }
}

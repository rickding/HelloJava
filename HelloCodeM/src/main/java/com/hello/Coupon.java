package com.hello;

import java.util.*;

/**
 * Created by user on 2017/6/13.
 */
public class Coupon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> ar = new ArrayList<String>(1024);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            ar.clear();

            // Scan the input values
            while (n-- > 0 && sc.hasNext()) {
                ar.add(sc.next());
            }

            // Check
            System.out.println(findValidLogs(ar));
        }

        sc.close();
    }

    /**
     * Scan and check the logs:
     * I x （I为Input的缩写，表示购买优惠券x）；
     * O x（O为Output的缩写，表示使用优惠券x）；
     * ? （表示这条记录不知道）。
     * @param logs
     * @return
     */
    public static long findValidLogs(List<String> logs) {
        if (logs == null || logs.size() <= 0) {
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
            if (values == null || values.length <= 0) {
                break;
            }

            // Free error?
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
                // If coupon exists, but it's not o, then it's wrong.
                if ("o".equalsIgnoreCase(value)) {
                    map.remove(key);
                } else if (freeErrors-- <= 0) {
                    break;
                }
            } else {
                // If coupon doesn't exist, but it's not i, then it's wrong.
                if ("i".equalsIgnoreCase(value)) {
                    map.put(key, value);
                } else if (freeErrors-- <= 0) {
                    break;
                }
            }
        }

        if (index >= logs.size() && freeErrors >= 0) {
            index = -1;
        }

        return index;
    }
}

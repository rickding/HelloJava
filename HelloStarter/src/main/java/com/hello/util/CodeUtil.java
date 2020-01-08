package com.hello.util;

import java.util.Random;

/**
 * 编码工具
 * @author Ding
 * @since 2019-09-23
 */
public class CodeUtil {
    private static Random random = new Random();
    private static int MAX_LEN = 15;

    /**
     * Generate the unique 24-number code: yyMMdd + time + 000
     */
    public static String getCode() {
        String timeStr = String.format("%015d", System.nanoTime());
        int len = timeStr.length();
        if (len > MAX_LEN) {
            timeStr = timeStr.substring(len - MAX_LEN, len);
        }
        return String.format("%s%s%03d", DateUtil.getTodayStr("yyMMdd"), timeStr, random.nextInt(1000));
    }
}

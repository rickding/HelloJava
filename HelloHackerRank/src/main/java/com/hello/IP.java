package com.hello;

public class IP {
    public static boolean isValid(String ip) {
        if (ip == null || ip.length() <= 0) {
            return false;
        }
        return ip.trim().matches(new MyRegex().pattern);
    }
}

class MyRegex {
    public String pattern = "((2(([0-4][0-9])|(5[0-5])))|([0-1]?[0-9]?[0-9]))" +
            ".((2(([0-4][0-9])|(5[0-5])))|([0-1]?[0-9]?[0-9]))" +
            ".((2(([0-4][0-9])|(5[0-5])))|([0-1]?[0-9]?[0-9]))" +
            ".((2(([0-4][0-9])|(5[0-5])))|([0-1]?[0-9]?[0-9]))";
}

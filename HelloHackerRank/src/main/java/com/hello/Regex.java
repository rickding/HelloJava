package com.hello;

import java.util.regex.Pattern;

public class Regex {
    public static boolean isValid(String regex) {
        if (regex == null || regex.trim().length() <= 0) {
            return false;
        }

        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (Exception e) {
        }
        return pattern != null;
    }
}

package com.hello.util;

import org.apache.commons.collections4.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具
 * @author Ding
 * @since 2017-09-23
 */
public class StrUtil {
    /**
     * String is null or empty
     */
    public static boolean isEmpty(String str) {
        return isEmpty(str, true);
    }

    public static boolean isEmpty(String str, boolean trim) {
        return str == null || str.isEmpty() || (trim && str.trim().length() <= 0);
    }

    public static boolean chkLen(String str, int minLen, int maxLen) {
        return str != null
                && str.length() >= Math.max(minLen, 0)
                && str.length() <= Math.min(Math.max(maxLen, 0), 1024);
    }

    public static String mask(String str) {
        return mask(str, 1, 12);
    }

    public static String mask(String str, int minLen, int maxLen) {
        if (isEmpty(str)) {
            return "";
        }

        str = str.trim().replace(" ", "")
                .replace("-", "")
                .replace("_", "");
        if (str.length() <= minLen && minLen > 0) {
            return str;
        }

        // Remove the middle part if it's too long
        if (maxLen > 0) {
            if (maxLen % 2 != 0) maxLen++;

            if (str.length() > maxLen) {
                str = String.format("%s%s",
                        str.substring(0, maxLen / 2),
                        str.substring(str.length() - maxLen / 2, str.length())
                );
            }
        }

        // Divide 3 parts: str+mask+str
        final int len = str.length();
        final int maskLen = len > 3 ? len / 3 : 1;
        StringBuffer sb = new StringBuffer(maskLen);
        for (int i = 0; i < maskLen; i++) {
            sb.append("*");
        }

        int startLen = (len - maskLen) / 2;
        return String.format("%s%s%s",
                str.substring(0, startLen), sb.toString(), str.substring(startLen + maskLen, len)
        );
    }

    /**
     * Match the part of version to the corresponding pattern
     */
    public static boolean matches(String str, String pattern) {
        if (isEmpty(str) || isEmpty(pattern)) {
            return false;
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String[] parse(String str, String pattern) {
        if (isEmpty(str) || isEmpty(pattern)) {
            return null;
        }

        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group());
        }
        if (list.size() <= 0) {
            return null;
        }

        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }

    public static boolean contains(String str, String subStr) {
        return contains(str, subStr, ",");
    }

    public static boolean contains(String str, String subStr, String separator) {
        if (isEmpty(str) || isEmpty(subStr)) {
            return false;
        }

        if (subStr.equalsIgnoreCase(str)) {
            return true;
        }

        String[] strArray = split(str, separator);
        if (strArray == null) {
            return false;
        }

        for (String tmpStr : strArray) {
            if (tmpStr.trim().length() == 0 && subStr.trim().length() == 0) {
                return true;
            }

            if (tmpStr.trim().equalsIgnoreCase(subStr.trim())) {
                return true;
            }
        }
        return false;
    }

    public static String[] split(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return null;
        }
        return str.split(separator);
    }

    public static String joinObj(Object[] objArr, String separator) {
        return objArr == null ? null : joinObj(Arrays.asList(objArr), separator);
    }

    public static String joinObj(Collection<Object> objList, String separator) {
        if (CollectionUtils.isEmpty(objList)) {
            return null;
        }

        List<String> strList = new ArrayList<String>();
        for (Object obj : objList) {
            strList.add(obj == null ? "" : obj.toString());
        }
        return join(strList, separator);
    }

    public static String join(String[] strArr, String separator) {
        return strArr == null ? null : join(Arrays.asList(strArr), separator);
    }

    public static String join(Collection<String> strList, String separator) {
        if (CollectionUtils.isEmpty(strList) || separator == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(separator);
            sb.append(str);
        }
        return sb.substring(separator.length());
    }

    /**
     * Get the bytes with UTF-8
     */
    public static byte[] getBytes(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isIdNumber(String idNumber) {
        if (idNumber == null || "".equals(idNumber.trim())) {
            return false;
        }

        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾

        boolean matches = idNumber.matches(regularExpression);
        if (matches && idNumber.length() == 18) {
            //判断第18位校验值
            try {
                //前十七位加权因子
                int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                //这是除以11后，可能产生的11位余数对应的验证码
                String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

                int sum = 0;
                char[] charArray = idNumber.toCharArray();
                for (int i = 0; i < idCardWi.length; i++) {
                    int current = Integer.parseInt(String.valueOf(charArray[i]));
                    int count = current * idCardWi[i];
                    sum += count;
                }

                char idCardLast = charArray[17];
                int idCardMod = sum % 11;
                if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                    return true;
                } else {
                    LogUtil.info("身份证最后一位错误: " + String.valueOf(idCardLast).toUpperCase() +
                            "，正确的应该是: " + idCardY[idCardMod].toUpperCase());
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.info("异常", idNumber);
                return false;
            }
        }
        return matches;
    }

    public static String trimChinese(String str) {
        return isEmpty(str) ? "" : str.replaceAll("[\u4e00-\u9fa5]+", "");
    }
}

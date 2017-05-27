package com.hello.quartz.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author user
 * @time 2015-9-15 上午10:05:31
 * @description <pre>
 * <p/>
 * </pre>
 */
public class DateUtil {
    /**
     * @return
     * @description <pre>
     * 返回当前时间YYMMDD格式
     * </pre>
     */
    public static String getYYMMDD() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        return sdf.format(d);
    }

    /**
     * @return
     * @description <pre>
     * 返回当前时间yyMMddHHmmSS格式
     * </pre>
     */
    public static String getYYMMDDHHmmSS() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd:HH:mm:ss");
        return sdf.format(d);
    }

    /**
     * @return
     * @description <pre>
     * 返回当前时间HHmmSS格式
     * </pre>
     */
    public static String getHHmmSS() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }

    /**
     * @param rule
     * @return
     * @description 按传入规则返回
     */
    public static String getStringDate(String rule, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(rule);
        return sdf.format(date);
    }

    public static Date getStartOfToday() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndOfToday() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
}
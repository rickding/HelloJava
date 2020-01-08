package com.hello.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期处理工具
 * @author Ding
 * @since 2017-09-23.p
 */
public class DateUtil {
    public static String getTodayStr() {
        return getTodayStr("MMdd");
    }

    public static String getTodayStr(String format) {
        return DateUtil.format(new Date(), format);
    }

    public static Date getToday() {
        return DateUtil.parse(DateUtil.format(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String format) {
        return format(date, format, Locale.US);
    }
    public static String format(Date date, String format, Locale locale) {
        if (date == null || StrUtil.isEmpty(format)) {
            return "";
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, locale == null ? Locale.US : locale);
            return sdf.format(date);
        } catch (Exception e) {
            LogUtil.error(e.getMessage(), format);
        }
        return "";
    }

    public static Date parse(String value, String[] formatArray) {
        return parse(value, formatArray, false);
    }

    public static Date parse(String value, String[] formatArray, boolean showError) {
        if (!StrUtil.isEmpty(value) && formatArray != null && formatArray.length > 0) {
            for (String format : formatArray) {
                Date date = DateUtil.parse(value, format, showError);
                if (date != null) {
                    return date;
                }
            }
        }

        if (showError) {
            LogUtil.error("Error when parse()", value, formatArray);
        }
        return null;
    }

    public static Date parse(String str) {
        return parse(str, "yyyy-MM-dd HH:mm:ss", true);
    }

    public static Date parse(String str, String format) {
        return parse(str, format, true);
    }

    public static Date parse(String str, String format, boolean showError) {
        if (StrUtil.isEmpty(str) || StrUtil.isEmpty(str.trim()) || StrUtil.isEmpty(format)) {
            return null;
        }

        try {
            DateFormat df = new SimpleDateFormat(format);
            return df.parse(str.trim());
        } catch (ParseException e) {
            if (showError) {
                LogUtil.error(e.getMessage(), format);
            }
        }
        return null;
    }

    public static int diffDates(String date1, String date2) {
        return diffDates(DateUtil.parse(date1, "yyyy-MM-dd"), DateUtil.parse(date2, "yyyy-MM-dd"));
    }

    public static int diffDates(Date d1, Date d2) {
        return diffDates(d1, d2, 1000 * 3600 * 24);
    }

    public static int diffDates(Date d1, Date d2, int radix) {
        if (d1 == null || d2 == null) {
            return 0;
        }
        return (int) ((d1.getTime() - d2.getTime()) / (radix > 0 ? radix : 1000));
    }

    public static int dayOfWeek(String strDate) {
        return dayOfWeek(parse(strDate, "yyyy-MM-dd"));
    }

    public static int dayOfWeek(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int dayOfMonth(String strDate) {
        return dayOfMonth(parse(strDate, "yyyy-MM-dd"));
    }

    public static int dayOfMonth(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Date adjustDate(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date getMonthStart(String dateStr) {
        return StrUtil.isEmpty(dateStr) ? null : getMonthStart(parse(dateStr, "yyyy-MM-dd"));
    }
    public static Date getMonthStart(Date date) {
        if (date == null) { return null; }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static Date getMonthEnd(String dateStr) {
        return StrUtil.isEmpty(dateStr) ? null : getMonthEnd(parse(dateStr, "yyyy-MM-dd"));
    }
    public static Date getMonthEnd(Date date) {
        if (date == null) { return null; }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, 31);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * Is Saturday or Sunday
     */
    public static boolean isWeekend(Date date) {
        if (date == null) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return Calendar.SATURDAY == day || Calendar.SUNDAY == day;
    }
}

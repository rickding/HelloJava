package com.hello.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtilTest {
    @Test
    public void testIsWeekend() {
        Map<String, Boolean> mapIO = new HashMap<String, Boolean>() {{
            put(null, false);
            put("", false);
            put("2018-04-16 00:00:00", false);
            put("2018-04-15 12:00:00", true);
            put("2018-04-14 00:00:00", true);
            put("2018-04-13 12:00:00", false);
            put("2018-04-12 00:00:00", false);
            put("2018-04-11 12:00:00", false);
            put("2018-04-10 00:00:00", false);
            put("2018-04-09 12:00:00", false);
        }};
        for (String key : mapIO.keySet()) {
            boolean ret = DateUtil.isWeekend(DateUtil.parse(key, "yyyy-MM-dd HH:mm:ss"));
            Assertions.assertEquals(mapIO.get(key), ret);
        }
    }

    @Test
    public void testParseDate() {
        Map<String, String> mapIO = new HashMap<String, String>() {{
            put("2017/11/17 5:43 下午", "2017-11-17"); // 解决
            put("2017/11/07 12:00 上午", "2017-11-07"); // 到期日
            put("2017/11/02 12:00 上午", "2017-11-02"); // 计划开始日期
            put("2017/11/20 6:11 下午", "2017-11-20"); // 实际上线日期
            put("2017-12-04 10:12:55", "2017-12-04"); // from DB
        }};

        List<String> dateFormatList = new ArrayList<String>() {{
            add("yyyy/MM/dd HH:mm:ss");
            add("yyyy/MM/dd HH:mm a");
            add("yyyy/MM/dd HH:mm");
            add("yyyy/MM/dd");
            add("yyyy-MM-dd HH:mm:ss");
            add("yyyy-MM-dd HH:mm");
            add("yyyy-MM-dd");
        }};
        String[] formatArray = new String[dateFormatList.size()];
        dateFormatList.toArray(formatArray);

        for (Map.Entry<String, String> io : mapIO.entrySet()) {
            Date ret = DateUtil.parse(io.getKey(), formatArray);
            Assertions.assertEquals(io.getValue(), DateUtil.format(ret, "yyyy-MM-dd"));
        }
    }

    @Test
    public void testDayOfWeek() {
        Map<String, Integer> mapIO = new HashMap<String, Integer>() {{
            put("", 0);
            put("", 0);
            put("yyyy/MM/dd HH:mm", 0);
            put("2017-12-07 18:00", Calendar.THURSDAY);
            put("2017-12-09 18:00", Calendar.SATURDAY);
            put("2017-12-07", Calendar.THURSDAY);
            put("2017-12-23", Calendar.SATURDAY);
            put("2017-12-24", Calendar.SUNDAY);
            put("2017-12-30", Calendar.SATURDAY);
        }};

        for (Map.Entry<String, Integer> io : mapIO.entrySet()) {
            int ret = DateUtil.dayOfWeek(io.getKey());
            Assertions.assertEquals(io.getValue().intValue(), ret);
        }
    }

    @Test
    public void testDiffDays() {
        Map<String[], Integer> mapIO = new HashMap<String[], Integer>() {{
            put(new String[]{null, ""}, 0);
            put(new String[]{"", ""}, 0);
            put(new String[]{"", "yyyy/MM/dd HH:mm"}, 0);
            put(new String[]{"2017-12-07 18:00", null}, 0);
            put(new String[]{"2017-12-09 18:00", "2017-12-09 12:00"}, 0);
            put(new String[]{"2017-12-07", "2017-12-09"}, -2);
            put(new String[]{"2018-01-02", "2017-12-30"}, 3);
            put(new String[]{"2017-12-13", "2017-11-16"}, 27);
        }};

        for (Map.Entry<String[], Integer> io : mapIO.entrySet()) {
            String[] params = io.getKey();
            int ret = DateUtil.diffDates(params[0], params[1]);
            Assertions.assertEquals(io.getValue().intValue(), ret);
        }
    }

    @Test
    public void testParse() {
        Map<String[], String[]> mapIO = new HashMap<String[], String[]>() {{
            put(new String[]{null, ""}, new String[]{"", ""});
            put(new String[]{"", ""}, new String[]{"", ""});
            put(new String[]{"", "yyyy/MM/dd HH:mm"}, new String[]{"", ""});
            put(new String[]{"2017/12/07 18:00", null}, new String[]{"", ""});
            put(new String[]{"2017/12/07 18:00", "yyyy/MM/dd HH:mm"}, new String[]{"2017-12-07 18:00", "yyyy-MM-dd HH:mm"});
            put(new String[]{"2017/12/07 12:00", "yyyy/MM/dd hh:mm"}, new String[]{"2017-12-07 12:00", "yyyy-MM-dd hh:mm"});
            put(new String[]{"2019-09-10T08:12:31.000+0800", "yyyy-MM-dd'T'HH:mm:ss.SSSZ"}, new String[]{"2019-09-10 08:12:31", "yyyy-MM-dd hh:mm:ss"});
        }};

        for (Map.Entry<String[], String[]> io : mapIO.entrySet()) {
            String[] params = io.getKey();
            Date ret = DateUtil.parse(params[0], params[1]);

            params = io.getValue();
            Assertions.assertEquals(params[0], DateUtil.format(ret, params[1]));
        }
    }

    @Test
    public void testFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        final Calendar cal = Calendar.getInstance();
        cal.setTimeZone(sdf.getTimeZone());

        cal.set(Calendar.YEAR, 2017);
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DATE, 23);
        cal.set(Calendar.HOUR, 5);
        cal.set(Calendar.MINUTE, 57);
        cal.set(Calendar.SECOND, 11);
        cal.set(Calendar.MILLISECOND, 12);
        cal.set(Calendar.AM_PM, Calendar.AM);

        final Date date = cal.getTime();

        Map<Object[], String> mapIO = new HashMap<Object[], String>() {{
            put(new Object[]{null, null}, "");
            put(new Object[]{date, null}, "");
            put(new Object[]{date, "yyyy"}, String.format("%04d", cal.get(Calendar.YEAR)));
            put(new Object[]{date, "yyyy-MM-dd hh:mm:sszzz"}, "2017-09-23 05:57:11CST");
        }};

        for (Map.Entry<Object[], String> io : mapIO.entrySet()) {
            Object[] params = io.getKey();
            String ret = DateUtil.format((Date) params[0], (String) params[1]);
            Assertions.assertEquals(io.getValue(), ret);
        }
    }
}

package com.hello;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDay {
    public static String getDay(String day, String month, String year) {
        if (day == null || day.length() <= 0 || month == null || month.length() <= 0 || year == null || year.length() <= 0) {
            return "";
        }

        String dateStr = String.format("%s-%s-%s", year, month, day);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {
            return "";
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayInt = cal.get(Calendar.DAY_OF_WEEK);
        return (new String[]{
                "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"
        })[dayInt - 1];
    }
}

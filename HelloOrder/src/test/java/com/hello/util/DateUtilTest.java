package com.hello.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

/**
 * Created by user on 2017/5/29.
 */

public class DateUtilTest {

    @Test
    public void testGetYYMMDD() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Loop with different values
        Map<String, String> io = new HashMap<String, String>() {{
            put("yy-MM-dd", "getYYMMDD");
            put("yy-MM-dd:HH:mm:ss", "getYYMMDDHHmmSS");
            put("HH:mm:ss", "getHHmmSS");
        }};

        for (Map.Entry<String, String> entry : io.entrySet()) {
            // Prepare the expected value
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat(entry.getKey());
            String expected = sdf.format(date);

            // Get the actual value and check
            Assert.assertEquals(expected, DateUtil.class.getMethod(entry.getValue()).invoke(DateUtil.class));
        }
    }

    @Test
    public void testGetStringDate() {
        // Mock date
        Date date = mock(Date.class);

        // Loop with different values
        String[] io = {"yyyy-MM-dd:HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss"};

        for (String i : io) {
            // Prepare the expected value
            String format = i;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String expected = sdf.format(date);

            // Get the actual value and check
            Assert.assertEquals(expected, DateUtil.getStringDate(format, date));
        }
    }
}

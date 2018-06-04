package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetDayTest {
    @Test
    public void testGetDay() {
        Map<String[], String> mapIO = new HashMap<String[], String>() {{
            put(new String[]{"05", "08", "2015"}, "WEDNESDAY");
            put(new String[]{"04", "06", "2018"}, "MONDAY");
            put(new String[]{"06", "06", "2018"}, "WEDNESDAY");
        }};

        for (Map.Entry<String[], String> io : mapIO.entrySet()) {
            String[] params = io.getKey();
            String ret = GetDay.getDay(params[0], params[1], params[2]);
            Assert.assertEquals(io.getValue(), ret);
        }
    }
}

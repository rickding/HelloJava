package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IPTest {
    @Test
    public void testIsValid() {
        Map<String, Boolean> mapIO = new HashMap<String, Boolean>() {{
            put("000.12.12.034", true);
            put("121.234.12.12", true);
            put("23.45.12.56", true);

            put("000.12.234.23.23", false);
            put("666.666.23.23", false);
            put(".213.123.23.32", false);
            put("23.45.22.32.", false);
            put("I.Am.not.an.ip", false);
            put("00.12.123.123123.123", false);
            put("122.23", false);
            put("Hello.IP", false);

            put("259.259.259.259", false);
            put("266.266.266.266", false);
            put("255.255.255.255", true);
            put("555.555.555.555", false);
            put("666.666.666.666", false);
            put("249.249.249.249", true);
            put("249.2", false);
        }};
        for (Map.Entry<String, Boolean> io : mapIO.entrySet()) {
            boolean ret = IP.isValid(io.getKey());
            if (io.getValue() != ret) {
                System.out.println(io.getKey());
            }
            Assert.assertEquals(io.getValue(), ret);
        }
    }
}

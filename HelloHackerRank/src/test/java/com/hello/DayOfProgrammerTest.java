package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DayOfProgrammerTest {
    @Test
    public void testResolve() {
        Map<Integer, String> ioMap = new HashMap<Integer, String>() {{
            put(2016, "12.09.2016");
        }};

        for (Map.Entry<Integer, String> io : ioMap.entrySet()) {
            String r = DayOfProgrammer.solve(io.getKey());

            if (!io.getValue().equals(r)) {
                System.out.println(r);
            }

            Assert.assertEquals(io.getValue(), r);
        }
    }
}

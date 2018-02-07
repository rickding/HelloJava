package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BracesTest {
    @Test
    public void testBraces() {
        Map<String[], String[]> mapIO = new HashMap<String[], String[]>() {{
            put(new String[] {"{}[]()"}, new String[] {"YES"});
            put(new String[] {"{[}]}"}, new String[] {"NO"});
        }};
        for (Map.Entry<String[], String[]> io : mapIO.entrySet()) {
            String[] ret = Braces.braces(io.getKey());
            Assert.assertArrayEquals(io.getValue(), ret);
        }
    }
}

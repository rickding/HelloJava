package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PalindromeTest {
    @Test
    public void testGetScore() {
        Map<String, Integer> mapIO = new HashMap<String, Integer>(){{
            put("acdapmpomp", 15);
            put("axbawbaseksqke", 25);
        }};

        for (Map.Entry<String, Integer> io : mapIO.entrySet()) {
            int ret = Palindrome.getScore(io.getKey());
            Assert.assertEquals(io.getValue().intValue(), ret);
        }
    }
}

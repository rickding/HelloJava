package com.hello;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitNumbersTest {
    @Test
    public void testSplitNumbers() {
        Map<String, String> ioMap = new HashMap<String, String>() {{
            put("101112", "YES 10");
            put("1234", "YES 1");
            put("91011", "YES 9");
            put("99100", "YES 99");
            put("101103", "NO");
            put("010203", "NO");
            put("13", "NO");
            put("1", "NO");
            put("11111111111111111111111111111111", "NO");
        }};

        List<BigInteger> numbers = new ArrayList<BigInteger>();
        for (Map.Entry<String, String> io : ioMap.entrySet()) {
            String str = io.getKey();

            numbers.clear();
            String ret = SplitNumbers.splitStr(str, 0, numbers) ? ("YES " + String.valueOf(numbers.get(0))) : "NO";

            if (!ret.equals(io.getValue())) {
                System.out.printf("%s %s", io.getValue(), ret);
            }

            Assert.assertEquals(io.getValue(), ret);
        }
    }
}

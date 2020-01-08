package com.hello.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class CodeUtilTest {
    @Test
    public void testGetCode() {
        final int count = Short.MAX_VALUE * 10;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < count; i++) {
            String code = CodeUtil.getCode();
            if (set.contains(code)) {
                LogUtil.info("duplicated", code);
                continue;
            }
            set.add(code);

            if (i == count - 1) {
                LogUtil.info("The last code", code);
            }
        }

        LogUtil.info("code count", count, "duplicated", count - set.size());
        Assertions.assertEquals(count, set.size());
    }
}

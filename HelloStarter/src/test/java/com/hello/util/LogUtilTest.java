package com.hello.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogUtilTest {
    @Test
    public void testLog() {
        LogUtil.debug("debug", "message.");
        LogUtil.info("info", "message.");
        LogUtil.warn("warn", "message.");
        LogUtil.error("error", "message.");
    }
}

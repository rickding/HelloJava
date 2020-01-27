package com.hello.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReaderTest {
    @Autowired
    Reader reader;

    @Test
    public void testRead() {
        String ret = reader.read("https://blog.csdn.net/xiziyidi/article/details/104088036");
        System.out.println(ret == null || ret.length() < 100 ? ret : ret.substring(0, 100));
        Assertions.assertNotNull(ret);
    }
}

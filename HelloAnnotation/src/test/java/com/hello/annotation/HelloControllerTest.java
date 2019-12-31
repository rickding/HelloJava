package com.hello.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloControllerTest {
    @Autowired
    HelloController helloController;

    @Test
    public void testHello() {
        String ret = helloController.hello("test");
        Assertions.assertTrue(ret.startsWith("test"));

        System.out.println(ret);
    }
}

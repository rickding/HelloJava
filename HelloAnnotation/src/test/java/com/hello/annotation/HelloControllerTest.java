package com.hello.annotation;

import com.hello.annotation.controller.HelloController;
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
        Object ret = helloController.hello("test", null);
        Assertions.assertTrue(ret.toString().contains("test"));

        System.out.println(ret);
    }
}

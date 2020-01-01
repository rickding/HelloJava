package com.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloBeanScopeTest {
    @Autowired
    HelloBean helloBean;

    @Test
    public void testValue() {
        String ret = helloBean.sayHello();
        Assertions.assertNotNull(ret);

        System.out.println(ret);
    }
}

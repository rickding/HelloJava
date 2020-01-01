package com.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloBeanScopeTest {
    @Autowired
    @Qualifier("helloBean")
    HelloBean beanScope;

    @Test
    public void testHello() {
        String ret = beanScope.sayHello();
        Assertions.assertNotNull(ret);

        System.out.println(ret);
    }
}

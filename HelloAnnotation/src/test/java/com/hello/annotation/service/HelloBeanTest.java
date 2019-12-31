package com.hello.annotation.service;

import com.hello.annotation.HelloAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;

@SpringBootTest
public class HelloBeanTest {
    @Autowired
    HelloBean helloBean;

    @Test
    public void testValue() {
        String ret = helloBean.osName;
        Assertions.assertNotNull(ret);

        System.out.println(String.format("osName：%s, resource: %s",
                helloBean.osName,
                helloBean.url.toString()
        ));
    }

    @Test
    public void testAnnotations() throws NoSuchMethodException {
        Class<?> clazz = HelloBean.class;
        Annotation[] annotations = clazz.getAnnotations();
        Assertions.assertNotNull(annotations);

        System.out.println(String.format("类： %s, 注解数量： %d",
                clazz.getSimpleName(),
                annotations.length
        ));
    }

    @Test
    public void testAnnotation() throws NoSuchMethodException {
        Class<?> clazz = HelloBean.class;
        HelloAnnotation annotation = clazz.getAnnotation(HelloAnnotation.class);
        Assertions.assertNotNull(annotation);

        System.out.println(String.format("类： %s, 注解： %s, 值：%s",
                clazz.getSimpleName(),
                annotation.annotationType().getSimpleName(),
                annotation.value()
        ));
    }
}

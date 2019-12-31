package com.hello.annotation.service;

import com.hello.annotation.HelloAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@HelloAnnotation("Hello Bean!")
public class HelloBean {
    @Value("#{systemProperties['os.name']}")
    String osName;

    @Value("http://www.baidu.com")
    Resource url;

    public HelloBean() {
        System.out.println("Bean is created.");
    }

    @Override
    public String toString() {
        return "HelloBean says hello world!";
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    public String sayHello() {
        return "Hello world!";
    }
}

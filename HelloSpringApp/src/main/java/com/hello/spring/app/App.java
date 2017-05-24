package com.hello.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Spring App!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
	}
}

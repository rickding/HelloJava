package com.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AopService service = (AopService) AopFactory.getAopProxyedObject("com.hello.AopServiceImpl");
        service.findInfo("Jonn from app.main");
    }
}

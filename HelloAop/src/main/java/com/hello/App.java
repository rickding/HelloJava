package com.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StudentInfoService infoService = (StudentInfoService) AopFactory.getAopProxyedObject("com.hello.StudentInfoServiceImpl");
        infoService.findInfo("Jonn from app.main");
    }
}

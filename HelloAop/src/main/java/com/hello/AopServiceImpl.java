package com.hello;

public class AopServiceImpl implements AopService {
    public void findInfo(String name) {
        System.out.println("The input name: " + name);
    }
}

package com.hello.hessian.service.impl;

import com.hello.hessian.model.HelloWorld;
import com.hello.hessian.service.HessianService;

/**
 * Created by user on 2017/6/4.
 */
public class HessianServiceImpl implements HessianService {
    @Override
    public HelloWorld sayHello(String name) {
        if (name == null || name.length() <= 0) {
            return sayHelloWorld();
        }

        System.out.println("sayHello()");

        StringBuilder sb = new StringBuilder("Hello ");
        sb.append(name);
        sb.append("!");
        return new HelloWorld(sb.toString());
    }

    @Override
    public HelloWorld sayHelloWorld() {
        System.out.println("sayHelloWorld()");
        return new HelloWorld("Hello World!");
    }
}

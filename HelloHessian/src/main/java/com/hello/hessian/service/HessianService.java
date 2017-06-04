package com.hello.hessian.service;

import com.hello.hessian.model.HelloWorld;

/**
 * Created by user on 2017/6/4.
 */
public interface HessianService {
    HelloWorld sayHelloWorld();
    HelloWorld sayHello(String name);
}

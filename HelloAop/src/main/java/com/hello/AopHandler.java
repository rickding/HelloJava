package com.hello;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopHandler implements InvocationHandler {
    private Object proxyObj;
    private static Logger log = Logger.getLogger(AopHandler.class);

    public Object bind(Object obj) {
        this.proxyObj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("Invoke method: " + method.getName());
        Object ret = method.invoke(proxyObj, args);
        return ret;
    }
}

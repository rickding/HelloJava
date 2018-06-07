package com.hello;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class AopInstrumenter implements MethodInterceptor {
    private Logger log = Logger.getLogger(AopInstrumenter.class);
    private Enhancer enhancer = new Enhancer();

    public Object getInstrumentedClass(Class clz) {
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.err.println("Intercept method: " + method.getName());
        Object ret = proxy.invokeSuper(obj, args);
        return ret;
    }
}

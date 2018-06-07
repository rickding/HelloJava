package com.hello;

public class AopFactory {
    private static Object getClassInst(String clzName) {
        Object obj = null;
        try {
            Class cls = Class.forName(clzName);
            obj = cls.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Object getAopProxyedObject(String clzName) {
        Object proxy = null;
        MyHandler handler = new MyHandler();
        Object obj = getClassInst(clzName);
        if (obj != null) {
            proxy = handler.bind(obj);
        } else {
            System.out.println("Can't get the proxyObj");
        }
        return proxy;
    }
}

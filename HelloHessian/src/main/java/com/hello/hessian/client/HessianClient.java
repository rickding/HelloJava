package com.hello.hessian.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hello.hessian.model.HelloWorld;
import com.hello.hessian.service.HessianService;

import java.net.MalformedURLException;

/**
 * Created by user on 2017/6/4.
 */
public class HessianClient {
    public static void main(String[] args) {
        String url = "http://localhost:8080/api";

        HessianProxyFactory factory = new HessianProxyFactory();
        HessianService service = null;

        try {
            service = (HessianService) factory.create(HessianService.class, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HelloWorld obj = service.sayHelloWorld();
        System.out.println(obj.getName());
    }
}

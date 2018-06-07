package com.hello;

import org.junit.Test;

public class AopFactoryTest {
    @Test
    public void testGetAopProxyedObject() {
        AopService service = (AopService) AopFactory.getAopProxyedObject("com.hello.AopServiceImpl");
        service.findInfo("Jonn from test");
    }
}

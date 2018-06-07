package com.hello;

import org.junit.Test;

public class AopFactoryTest {
    @Test
    public void testGetAopProxyedObject() {
        AopService service = (AopService) AopFactory.getAopProxyedObject(AopServiceImpl.class.getName());
        service.findInfo("Jonn from test");
    }
}

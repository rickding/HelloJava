package com.hello;

import org.junit.Test;

public class AopFactoryTest {
    @Test
    public void testGetAopProxyedObject() {
        StudentInfoService infoService = (StudentInfoService) AopFactory.getAopProxyedObject("com.hello.StudentInfoServiceImpl");
        infoService.findInfo("Jonn from test");
    }
}

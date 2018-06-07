package com.hello;

import org.junit.Test;

public class AopInstrumenterTest {
    @Test
    public void testGetInstrumentedObject() {
        AopInstrumenter instrumenter = new AopInstrumenter();
        AopService service = (AopService) instrumenter.getInstrumentedClass(AopServiceImpl.class);
        service.findInfo("Instrumenter from test");
    }
}

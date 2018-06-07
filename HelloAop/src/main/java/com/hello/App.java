package com.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AopService service = (AopService) AopFactory.getAopProxyedObject(AopServiceImpl.class.getName());
        service.findInfo("Jonn from app.main");

        AopInstrumenter instrumenter = new AopInstrumenter();
        service = (AopService) instrumenter.getInstrumentedClass(AopServiceImpl.class);
        service.findInfo("Instumenter from app.main");
    }
}

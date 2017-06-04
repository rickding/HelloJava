package com.hello.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hello.hessian.model.HelloWorld;
import com.hello.hessian.service.HessianService;
import org.junit.*;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017/6/4.
 */
public class HessianServiceTest {
    private static HessianService service = null;

    @BeforeClass
    public static void setUp() {
        String url = "http://localhost:8080/api";

        HessianProxyFactory factory = new HessianProxyFactory();

        try {
            service = (HessianService) factory.create(HessianService.class, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (null != service) {
            service = null;
        }
    }

    @Test
    public void testHelloWorld() {
        if (service == null) {
            return;
        }
        HelloWorld obj = service.sayHelloWorld();
        Assert.assertEquals("Hello World!", obj.getName());
    }

    @Test
    public void testHelloWorldWithName() {
        if (service == null) {
            return;
        }

        Map<String, String> io = new HashMap() {{
            put(null, "Hello World!");
            put("", "Hello World!");
            put("a", "Hello a!");
            put("name", "Hello name!");
        }};
        for (Map.Entry<String, String> i : io.entrySet()) {
            HelloWorld obj = service.sayHello(i.getKey());
            Assert.assertEquals(i.getValue(), obj.getName());
        }
    }
}

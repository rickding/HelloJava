package com.hello.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServerConfigTest {
    @Autowired
    ServerConfig serverConfig;

    @Test
    public void testServerUrl() {
        String ret = serverConfig.getServerUrl();
        Assertions.assertTrue(ret.contains("http://192."));

        System.out.println(ret);
    }
}

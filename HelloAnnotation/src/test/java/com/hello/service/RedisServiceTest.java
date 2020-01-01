package com.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisServiceTest {
    @Autowired
    RedisService redisService;

    @Test
    public void testInc() {
        String key = "RedisServiceTest.testStr";
        Long ret = redisService.incr(key);
        Assertions.assertNotNull(ret);

        System.out.println(ret);
        redisService.expire(key, 1);
    }
}

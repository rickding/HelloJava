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
    public void testIncr() {
        String key = "RedisServiceTest.testStr";
        long ret = redisService.incr(key);
        Assertions.assertTrue(ret > 0);

        System.out.println(ret);
        redisService.expire(key, 1);
    }
}

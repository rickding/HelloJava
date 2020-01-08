package com.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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

    @Test
    public void testStr() {
        final String key = "RedisServiceTest.testStr";
        System.out.println("String before set: " + redisService.getStr(key));

        final String str = key + ": " + new Date().toString();
        redisService.setStr(key, str);

        final String newStr = redisService.getStr(key);
        System.out.println("New String value: " + newStr);
        Assertions.assertEquals(str, newStr);

        redisService.delStr(key);
        final String delStr = redisService.getStr(key);
        System.out.println("String after del: " + delStr);
        Assertions.assertNull(delStr);
    }

    @Test
    public void testObj() {
        final Object key = new Date();
        System.out.println("Obj before set: " + redisService.getObj(key));

        final Object obj = new Date();
        redisService.setObj(key, obj);

        final Object newObj = redisService.getObj(key);
        System.out.println("New obj value: " + newObj);
        Assertions.assertEquals(obj, newObj);

        redisService.delObj(key);
        final Object delObj = redisService.getObj(key);
        System.out.println("Obj after del: " + delObj);
        Assertions.assertNull(delObj);
    }
}

package com.hello.service;

import com.hello.util.LogUtil;
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

        LogUtil.info(ret);
        redisService.expire(key, 1);
    }

    @Test
    public void testStr() {
        final String key = "RedisServiceTest.testStr";
        LogUtil.info("String before set", redisService.getStr(key));

        final String str = key + ": " + new Date().toString();
        redisService.setStr(key, str);

        final String newStr = redisService.getStr(key);
        LogUtil.info("New String value", newStr);
        Assertions.assertEquals(str, newStr);

        redisService.delStr(key);
        final String delStr = redisService.getStr(key);
        LogUtil.info("String after del", delStr);
        Assertions.assertNull(delStr);
    }

    @Test
    public void testObj() {
        final Object key = new Date();
        LogUtil.info("Obj before set", redisService.getObj(key));

        final Object obj = new Date();
        redisService.setObj(key, obj);

        final Object newObj = redisService.getObj(key);
        LogUtil.info("New obj value", newObj);
        Assertions.assertEquals(obj, newObj);

        redisService.delObj(key);
        final Object delObj = redisService.getObj(key);
        LogUtil.info("Obj after del", delObj);
        Assertions.assertNull(delObj);
    }
}

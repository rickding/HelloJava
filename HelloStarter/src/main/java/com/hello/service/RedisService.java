package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis服务封装
 * @author Ding
 * @since 2020-01-08
 */
@Service
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("all")
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> strValOps;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @SuppressWarnings("all")
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> objValOps;

    public long incr(String key) {
        Long ret = strValOps.increment(key, 1L);
        return ret == null ? 0 : ret;
    }

    public boolean expire(String key, long seconds) {
        Boolean ret = stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        return ret == null ? false : ret;
    }

    /**
     * String operation
     */
    public void delStr(String key) {
        stringRedisTemplate.delete(key);
    }

    public String getStr(String key) {
        return strValOps.get(key);
    }

    public void setStr(String key, String v) {
        strValOps.set(key, v);
    }

    public void setStr(String key, String v, long seconds) {
        strValOps.set(key, v, seconds, TimeUnit.SECONDS);
    }

    public void setStr1Minute(String key, String v) {
        setStr(key, v, 60);
    }

    public void setStr5Minutes(String key, String v) {
        setStr(key, v, 60 * 5);
    }

    public void setStr1Hour(String key, String v) {
        setStr(key, v, 3600);
    }

    public void setStr1Day(String key, String v) {
        setStr(key, v, 3600 * 24);
    }

    public void setStr1Week(String key, String v) {
        setStr(key, v, 3600 * 24 * 7);
    }

    public void setStr1Month(String key, String v) {
        setStr(key, v, 3600 * 24 * 30);
    }

    /**
     * Object operation
     */
    public void delObj(Object key) {
        redisTemplate.delete(key);
    }

    public Object getObj(Object key) {
        return objValOps.get(key);
    }

    public void setObj(Object key, Object v) {
        objValOps.set(key, v);
    }

    public void setObj(Object key, Object v, long seconds) {
        objValOps.set(key, v, seconds, TimeUnit.SECONDS);
    }

    public void setObj1Minute(Object key, Object v) {
        setObj(key, v, 60);
    }

    public void setObj5Minutes(Object key, Object v) {
        setObj(key, v, 60 * 5);
    }

    public void setObj1Hour(Object key, Object v) {
        setObj(key, v, 3600);
    }

    public void setObj1Day(Object key, Object v) {
        setObj(key, v, 3600 * 24);
    }

    public void setObj1Week(Object key, Object v) {
        setObj(key, v, 3600 * 24 * 7);
    }

    public void setObj1Month(Object key, Object v) {
        setObj(key, v, 3600 * 24 * 30);
    }
}

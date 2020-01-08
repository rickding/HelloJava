package com.hello.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hello.annotation.AccessLimited;
import com.hello.entity.Log;
import com.hello.mapper.LogMapper;
import com.hello.mq.ActiveMqService;
import com.hello.service.RedisService;
import com.hello.util.CodeUtil;
import com.hello.util.LogUtil;
import com.hello.util.RespUtil;
import com.hello.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 服务检查接口
 *
 * @author Ding
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/")
public class CheckController {
    @Autowired
    private ActiveMqService activeMqService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private LogMapper logMapper;

    @AccessLimited(count = 1)
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object index(@RequestAttribute(required = false) String ip) {
        return new HashMap<String, Object>() {{
            put("ip", ip);
            put("msg", String.format("Hello, Starter! %s", this.getClass().getName()));
        }};
    }

    @AccessLimited(count = 1)
    @GetMapping(value = "chk")
    public Object chk(@RequestAttribute(required = false) String ip) {
        return new HashMap<String, Object>() {{
            put("chk", "ok");
            put("msg", ip);
        }};
    }

    @AccessLimited(count = 1)
    @GetMapping(path = "mq")
    public Object mq(@RequestAttribute(required = false) String ip) {
        if (StrUtil.isEmpty(ip)) {
            ip = String.format("check mq %s", new Date().toString());
        }
        activeMqService.send(ip);

        final String msg = ip;
        return new HashMap<String, Object>() {{
            put("chk", "mq");
            put("msg", msg);
        }};
    }

    @AccessLimited(count = 1)
    @GetMapping(value = "/cache")
    public Object cache(@RequestAttribute(required = false) String ip) {
        // Get a unique key
        String key = null;
        while (key == null || redisService.getStr(key) != null) {
            key = String.format("cache_test_%s_%s", ip, CodeUtil.getCode());
        }

        // Set and get cache
        redisService.setStr(key, key, 3);

        // Get cache
        String str = redisService.getStr(key);
        LogUtil.info("Check cache to set str", key, str);

        // Delete cache
        redisService.delStr(key);

        boolean status = key.equals(str);
        return new HashMap<String, Object>() {{
            put("chk", "cache");
            put("msg", str);
            put("status", status);
        }};
    }

    @AccessLimited(count = 1)
    @GetMapping(value = "/db")
    public Object db(@RequestAttribute String ip) {
        // Write a test log to db
        Log log = new Log() {{
            setSummary(String.format("db_test_%s_%s", ip, new Date().toString()));
        }};
        logMapper.insert(log);
        LogUtil.info("Check db to insert log", log.getSummary());

        // Read log from db
        Log ret = logMapper.selectOne(new QueryWrapper<Log>().orderByDesc("id").eq("summary", log.getSummary()));
        Integer count = logMapper.selectCount(null);

        return new HashMap<String, Object>() {{
            put("chk", "db");
            put("msg", log.getSummary());
            put("status", ret != null && log.getSummary().equals(ret.getSummary()));
            put("count", count);
        }};
    }
}

package com.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
public class MqServiceTest {
    @Autowired
    MqService mqService;

    Object[] msgArr = new Object[] {
            String.format("test mq: %s", new Date().toString()),
            new HashMap<String, Object>() {{
                put("msg", "map msg");
                put("date", new Date().toString());
            }},
            "byte msg".getBytes()
    };

    @Test
    public void testSendQueue() {
        for (Object obj : msgArr) {
            mqService.sendQueue(obj);
        }
    }

    @Test
    public void testSendTopic() {
        for (Object obj : msgArr) {
            mqService.sendTopic(obj);
        }
    }
}

package com.hello.mq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ActiveMqServiceTest {
    @Autowired
    ActiveMqService activeMqService;

    @Test
    public void testSendQueue() {
        activeMqService.sendQueue(String.format("test active queue: %s", new Date().toString()));
    }

    @Test
    public void testSendTopic() {
        activeMqService.sendTopic(String.format("test active topic: %s", new Date().toString()));
    }
}

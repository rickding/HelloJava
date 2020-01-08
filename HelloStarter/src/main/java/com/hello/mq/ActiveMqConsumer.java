package com.hello.mq;

import com.hello.util.LogUtil;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqConsumer {
    @JmsListener(destination = "starter.queue")
    public void listenQueue(String msg) {
        LogUtil.info("Receive queue msg", msg);
    }

    @JmsListener(destination = "starter.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void listenTopic(String msg) {
        LogUtil.info("Receive topic msg", msg);
    }
}

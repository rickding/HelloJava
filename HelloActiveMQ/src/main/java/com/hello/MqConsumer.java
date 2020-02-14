package com.hello;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {
    @JmsListener(destination = "hello.queue")
    public void listenQueue(ActiveMQMessage msg) {
        System.out.printf("Receive queue msg: %s, %s\n", msg.getJMSXMimeType(), msg.getClass().getSimpleName());
    }

    @JmsListener(destination = "hello.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void listenTopic(ActiveMQMessage msg) {
        System.out.printf("Receive topic msg: %s, %s\n", msg.getJMSXMimeType(), msg.getClass().getSimpleName());
    }
}

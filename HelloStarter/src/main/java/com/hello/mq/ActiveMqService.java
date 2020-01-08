package com.hello.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * ActiveMQ服务封装
 * @author Ding
 * @since 2020-01-08
 */
@Service
public class ActiveMqService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void send(String msg) {
        sendQueue(msg);
    }

    public void sendQueue(String msg) {
        jmsMessagingTemplate.convertAndSend(queue, msg);
    }

    public void sendTopic(String msg) {
        jmsMessagingTemplate.convertAndSend(topic, msg);
    }
}

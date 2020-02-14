package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class MqService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendQueue(Object msgObj) {
        System.out.printf("Send queue msg: %s\n", msgObj);

        try {
            jmsMessagingTemplate.convertAndSend(queue, msgObj);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void sendTopic(Object msgObj) {
        System.out.printf("Send topic msg: %s\n", msgObj);

        try {
            jmsMessagingTemplate.convertAndSend(topic, msgObj);
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

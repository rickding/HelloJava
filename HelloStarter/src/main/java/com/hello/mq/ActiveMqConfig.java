package com.hello.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@EnableJms
@Configuration
public class ActiveMqConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("starter.queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("starter.topic");
    }

    /**
     * 默认只配置queue类型消息，如果要使用topic类型的消息，则需要配置factory
     */
    @Bean
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}

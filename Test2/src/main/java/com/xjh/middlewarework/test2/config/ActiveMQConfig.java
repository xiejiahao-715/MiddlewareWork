package com.xjh.middlewarework.test2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ActiveMQConfig{

    public final static String TEST_QUEUE = "test-queue";

    public final static String TEST_TOPIC = "test-topic";

    // 存储物流消息的队列
    public final static String LOGISTICS_QUEUE = "logistics-queue";

    public final static String TOPIC_LISTENER_FACTORY = "topicListenerFactory";

    public final static String QUEUE_LISTENER_FACTORY = "queueListenerFactory";

    @Bean(TEST_QUEUE)
    public Queue testQueue(){
        return new ActiveMQQueue(TEST_QUEUE);
    }

    @Bean(TEST_TOPIC)
    public Topic testTopic(){
        return new ActiveMQTopic(TEST_TOPIC);
    }

    @Bean(LOGISTICS_QUEUE)
    public Queue logisticsQueue(){
        return new ActiveMQQueue(LOGISTICS_QUEUE);
    }

    @Bean(TOPIC_LISTENER_FACTORY)
    public JmsListenerContainerFactory<?> topicListenerFactory(@Autowired ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean(QUEUE_LISTENER_FACTORY)
    public JmsListenerContainerFactory<?> queueListenerFactory(@Autowired ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

}

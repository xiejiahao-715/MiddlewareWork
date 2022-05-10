package com.xjh.middlewarework.test2.consumer;

import com.xjh.middlewarework.test2.config.ActiveMQConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

// 代码测试-消费者
@Component
public class TestConsumer {
    // 监听队列的消费者
    @JmsListener(
            destination = ActiveMQConfig.TEST_QUEUE,
            containerFactory = ActiveMQConfig.QUEUE_LISTENER_FACTORY)
    public void consumerOfQueue(TextMessage message) throws JMSException {
        System.out.println("监听queue的消费者接收到消息" + message.getText());
    }
    // 监听topic的消费者
    @JmsListener(
            destination = ActiveMQConfig.TEST_TOPIC,
            containerFactory = ActiveMQConfig.TOPIC_LISTENER_FACTORY)
    public void consumerOfTopic(TextMessage message) throws JMSException {
        System.out.println("监听topic的消费者接受到消息" + message.getText());
    }
}

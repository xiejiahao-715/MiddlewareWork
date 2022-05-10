package com.xjh.middlewarework.test2.producer;

import com.xjh.middlewarework.test2.config.ActiveMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.UUID;


// 代码测试-生产者
@Component
public class TestProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name= ActiveMQConfig.TEST_QUEUE)
    private Queue testQueue;

    @Resource(name = ActiveMQConfig.TEST_TOPIC)
    private Topic testTopic;

    public void testSendMsg() throws JMSException {
        String msg = "***"+ UUID.randomUUID().toString().substring(0, 6);
        jmsMessagingTemplate.convertAndSend(testQueue, msg);
        System.out.println("消息推送到ActiveMQ的队列("+ testQueue.getQueueName()  +")成功,消息：" + msg);

        jmsMessagingTemplate.convertAndSend(testTopic, msg);
        System.out.println("消息推送到ActiveMQ的topic("+ testTopic.getTopicName()  +")成功，消息："+ msg);
    }

}

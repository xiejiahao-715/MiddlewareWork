package com.xjh.middlewarework.test2.consumer;

import com.xjh.middlewarework.test2.config.ActiveMQConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class LogisticsConsumer {
    // 物流信息的消费者
    @JmsListener(
            destination = ActiveMQConfig.LOGISTICS_QUEUE,
            containerFactory = ActiveMQConfig.QUEUE_LISTENER_FACTORY)
    public void getLogisticsInfo(TextMessage message) throws JMSException {
        System.out.println(message.getText());
    }
}



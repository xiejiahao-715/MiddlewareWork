package com.xjh.middlewarework.test2;

import com.xjh.middlewarework.test2.producer.ScheduleProducer;
import com.xjh.middlewarework.test2.producer.TestProducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class TestActiveMQ {
    @Autowired
    private TestProducer testProducer;

    @Autowired
    private ScheduleProducer scheduleProducer;

    @Test
    public void test() throws JMSException {
        testProducer.testSendMsg();
    }

    @Test
    public void testLogistics (){
        scheduleProducer.syncSchedule();
    }

    // 连接rabbitmq的方法
    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://www.xiejiahao.top:61616");
        Connection connection = factory.createConnection();
        connection.start();
        // 建立会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("test-谢嘉豪");

        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage();

        message.setText("2894894984");

        producer.send(message);

        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(message1 -> {
            try {
                System.out.println("消费者："+ ((TextMessage) message1).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        consumer.close();
        producer.close();
        session.close();
        connection.close();
    }
}

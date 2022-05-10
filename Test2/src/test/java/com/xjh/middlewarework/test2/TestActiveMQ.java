package com.xjh.middlewarework.test2;

import com.xjh.middlewarework.test2.consumer.LogisticsConsumer;
import com.xjh.middlewarework.test2.producer.ScheduleProducer;
import com.xjh.middlewarework.test2.producer.TestProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

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
}

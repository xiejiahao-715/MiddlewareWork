package com.xjh.middlewarework.test2.producer;

import com.xjh.middlewarework.test2.config.ActiveMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 物流进程的生成者，模拟多个生产者发送消息
@Component
public class ScheduleProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 存储物流消息的队列
    @Resource(name= ActiveMQConfig.LOGISTICS_QUEUE)
    private Queue logisticsQueue;

    public void syncSchedule(){
        List<String> messages = Arrays.asList(
                "买家已发货",
                "快件在上海，正转运至上海集海中心",
                "顺丰速运已收取快件",
                "快件在上海集散中心,正转运至上海虹桥集散中心",
                "快件在上海虹桥集散中心,正转运至武汉吴家山集散中心",
                "快件在武汉吴家山集散中心,正转运至武汉北港服务点正在派送途中,请您准备签收",
                "在官网运单资料&签收图",
                "可查看签收人信息已签收,感谢使用顺丰,期待再次为您服务"
        );
        LocalDateTime dateTime = LocalDateTime.of(2020,1,5,1,30);
        for (String message : messages) {
            jmsMessagingTemplate.convertAndSend(logisticsQueue,
                    dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ":" + message);
            dateTime = dateTime.plusHours(2);
        }
    }
}

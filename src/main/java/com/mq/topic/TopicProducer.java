package com.mq.topic;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

@Data
@Slf4j
public class TopicProducer {

    private static final String ACTIVEMQ_URL = "tcp://192.168.206.130:61616";
    private static final String TOPIC_NAME = "Topic-01";

    public static void main(String[] args) {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            // 创建连接，并开启连接
            Connection connection = factory.createConnection();
            connection.start();
            // 连接创建对话，并创建目的地（主体或队列）
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            // TODO
            // Session session = connection.createSession();
            Topic topic = session.createTopic(TOPIC_NAME);
            // 对话创建生产者/消费者，创建时设置好目的地
            MessageProducer producer = session.createProducer(topic);
            // 生产者/消费者，与MQ交互
            for (int i = 0; i < 100; i++) {
                TextMessage textMessage = session.createTextMessage("topicMessage:" + i);
                producer.send(textMessage);
            }
            producer.close();
            session.close();
            connection.close();

            System.out.println("sucess");

        } catch (Exception e){
            log.debug("wrong",e);
        }

    }
}

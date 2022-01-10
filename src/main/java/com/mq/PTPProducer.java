package com.mq;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

@Data
@Slf4j
public class PTPProducer {

    private static final String ACTIVEMQ_URL = "tcp://192.168.77.128:61616";
    private static final String QUEUE_NAME = "PTP";

    public static void main(String[] args) {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);


            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            // TODO
            // Session session = connection.createSession();
            Queue queue = session.createQueue(QUEUE_NAME);


            MessageProducer producer = session.createProducer(queue);
            // producer.setDeliveryMode();

            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = session.createTextMessage("msg:" + i);
                //textMessage.setJMSDeliveryMode();
                producer.send(textMessage);
            }
            producer.close();
            session.close();
            connection.close();

            System.out.println("sucess");

        } catch (Throwable t){
            log.debug("wrong",t);
        }

    }
}

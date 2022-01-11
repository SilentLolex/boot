package com.mq.p2p;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: SilentLolex
 * @Date: 20220111
 */

@Data
@Slf4j
public class PtpProducer {

    private static final String ACTIVEMQ_URL = "tcp://192.168.206.130:61616";
    private static final String QUEUE_NAME = "PTP";
    private static final int MESSAGE_NUM = 100000;

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

            for (int i = 0; i < MESSAGE_NUM; i++) {
                TextMessage textMessage = session.createTextMessage("msg:" + i);
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

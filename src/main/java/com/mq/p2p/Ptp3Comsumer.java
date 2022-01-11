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
public class Ptp3Comsumer {
    private static final String ACTIVEMQ_URL = "tcp://192.168.206.130:61616";
    private static final String QUEUE_NAME = "PTP";

    public static void main(String[] args) {
        log.debug("33333");
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(QUEUE_NAME);


            MessageConsumer consumer = session.createConsumer(queue);

            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage receive = (TextMessage) message;
                    String text = null;
                    try {
                        text = receive.getText();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                    log.debug(text);
                }
            });

            /*for (int i = 0; i < 3; i++) {
                TextMessage receive = (TextMessage)consumer.receive(3000);
                String text = receive.getText();
                log.debug(text);
            }*/
            System.in.read();
            consumer.close();
            session.close();
            connection.close();

            System.out.println("sucess");

        } catch (Exception e){
            log.debug("wrong",e);
        }

    }
}

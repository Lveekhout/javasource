package nl.lveekhout;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jms.AQjmsDestination;
import oracle.jms.AQjmsFactory;
import oracle.jms.AQjmsSession;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OracleAqListener {
    public static void main(String[] args) throws SQLException, JMSException, InterruptedException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL("jdbc:oracle:thin:@pps-oradbs01.dev.tkp:1521/ppsdev");
        dataSource.setUser("pas");
        dataSource.setPassword("pas");

        //Detectie van locks op de dequeue voor het tonen op het beheerscherm.
        java.util.Properties props = new java.util.Properties();
        props.put("v$session.program", "aq_listener");

        dataSource.setConnectionProperties(props);

        ConnectionFactory factory = AQjmsFactory.getConnectionFactory(dataSource);

        Connection connection = factory.createConnection();
        AQjmsSession session = (AQjmsSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        AQjmsDestination destination = (AQjmsDestination) session.getQueue("AQ$PPS", "PASPOORT_PSN_RPN_Q");
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                try {
                    System.out.println("[" + format.format(new Date()) + "] " + ((TextMessage)message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        connection.start();

        System.out.println("Listening!");
        while (true) Thread.sleep(1000);
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        while (true) System.out.println("[" + format.format(new Date()) + "] " + ((TextMessage)consumer.receive()).getText());
    }
}
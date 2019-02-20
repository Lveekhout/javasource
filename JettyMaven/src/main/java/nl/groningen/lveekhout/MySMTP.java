package nl.groningen.lveekhout;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by eekhout.l on 30-11-2015.
 * class MySMTP
 */
public class MySMTP {

    public static void main(String args[]) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("leekhout@hotmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lveekhout@gmail.com", false));
        msg.setSubject("System.currentTimeMillis() " + System.currentTimeMillis());
        msg.setText("Med vennlig hilsennTov Are Jacobsen");
//        msg.setHeader("X-Mailer", "Tov Are's program");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.gmail.com", "lveekhout@gmail.com", "gmail101");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
}
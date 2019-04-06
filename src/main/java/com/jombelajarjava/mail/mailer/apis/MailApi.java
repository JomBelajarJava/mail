package com.jombelajarjava.mail.mailer.apis;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Logger;

import static javax.mail.Message.RecipientType.TO;

/**
 * Component to call Appengine Mail API.
 */
@Component
public class MailApi {
    private static final Logger LOG = Logger.getLogger(MailApi.class.getName());

    /**
     * Send email using Appengine Mail API. The call returns immediately.
     *
     * @param email Email to be sent
     */
    public boolean send(Email email) {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(email.getFrom()));
            message.setRecipient(TO, new InternetAddress(email.getTo()));
            message.setText(email.getText());
            message.setSubject(email.getSubject());

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            LOG.warning(e.getMessage());
            return false;
        }
    }
}

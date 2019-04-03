package com.jombelajarjava.mail.mailer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

import static javax.mail.Message.RecipientType.TO;

@Service
public class MailingService {
    private static final Logger LOG = Logger.getLogger(MailingService.class.getName());

    @Value("${mailer.sender.email}")
    private String senderEmail;

    @Value("${mailer.sender.name}")
    private String senderName;

    @Value("${mailer.admin.email}")
    private String adminEmail;

    /**
     * Send email using Appengine Mail API. The call returns immediately.
     *
     * @param email Email to be sent
     */
    public void send(Email email) {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(senderEmail, senderName));
            message.addRecipient(TO, new InternetAddress(adminEmail));
            message.setText(email.getContent());
            message.setSubject(composeSubject(email));

            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            LOG.warning(e.getMessage());
        }
    }

    /**
     * Compose email subject depending on whether user entered their email or not.
     *
     * @param email Input email
     * @return Email subject
     */
    private String composeSubject(Email email) {
        if (email.getFrom() != null && !email.getFrom().isEmpty()) {
            return "[JomBelajarJava] Email dari " + email.getName() + " (" + email.getFrom() + ")";
        } else {
            return "[JomBelajarJava] Email dari " + email.getName();
        }
    }
}

package com.jombelajarjava.mail.mailer.apis;

import com.jombelajarjava.mail.mailer.Email;
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

import static com.jombelajarjava.mail.mailer.utils.EmailUtils.composeSubject;
import static javax.mail.Message.RecipientType.TO;

/**
 * Service to call Appengine Mail API.
 */
@Service
public class MailApiService {
    private static final Logger LOG = Logger.getLogger(MailApiService.class.getName());

    @Value("${mailer.mailapi.email}")
    private String mailAPIEmail;

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
            message.setFrom(new InternetAddress(mailAPIEmail, senderName));
            message.addRecipient(TO, new InternetAddress(adminEmail));
            message.setText(email.getContent());
            message.setSubject(composeSubject(email));

            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            LOG.warning(e.getMessage());
        }
    }
}

package com.jombelajarjava.mail.mailer.utils;

import com.jombelajarjava.mail.mailer.apis.Email;
import com.jombelajarjava.mail.mailer.forms.ContactForm;
import com.jombelajarjava.mail.mailer.forms.DonationForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.jombelajarjava.mail.mailer.utils.EmailUtils.composeBody;
import static com.jombelajarjava.mail.mailer.utils.EmailUtils.composeSubject;

@Component
public class EmailMapper {
    @Value("${mailer.sender.name}")
    private String senderName;

    @Value("${mailer.mailapi.email}")
    private String defaultSenderEmail;

    @Value("${mailer.mailgun.email}")
    private String mailgunSenderEmail;

    @Value("${mailer.admin.email}")
    private String adminEmail;

    /**
     * Compose contact form into email.
     *
     * @param form Contact form
     * @return Email to be sent
     */
    public Email compose(ContactForm form) {
        return Email.builder()
                .fromName(senderName)
                .fromEmail(defaultSenderEmail)
                .to(adminEmail)
                .subject(composeSubject(form))
                .text(form.getContent())
                .build();
    }

    /**
     * Compose donation form into email.
     *
     * @param form Donation form
     * @return Email to be sent
     */
    public Email compose(DonationForm form) {
        return Email.builder()
                .fromName(senderName)
                .fromEmail(defaultSenderEmail)
                .to(adminEmail)
                .subject(composeSubject(form))
                .text(composeBody(form))
                .build();
    }
}

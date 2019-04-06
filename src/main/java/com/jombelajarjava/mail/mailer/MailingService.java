package com.jombelajarjava.mail.mailer;

import com.google.apphosting.api.ApiProxy;
import com.jombelajarjava.mail.mailer.apis.Email;
import com.jombelajarjava.mail.mailer.apis.MailApi;
import com.jombelajarjava.mail.mailer.apis.MailgunApi;
import com.jombelajarjava.mail.mailer.forms.ContactForm;
import com.jombelajarjava.mail.mailer.forms.DonationForm;
import com.jombelajarjava.mail.mailer.utils.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
    @Value("${mailer.mailapi.email}")
    private String mailApiEmail;

    @Value("${mailer.mailgun.email}")
    private String mailgunEmail;

    @Autowired
    private EmailMapper mapper;

    @Autowired
    private MailApi mailApi;

    @Autowired
    private MailgunApi mailgunApi;

    /**
     * Compose email from contact form and send it.
     *
     * @param form Contact form
     */
    public boolean contactUs(ContactForm form) {
        Email email = mapper.compose(form);
        return sendEmail(email);
    }

    /**
     * Compose email from donation form and send it.
     *
     * @param form Donation form
     */
    public boolean informDonation(DonationForm form) {
        Email email = mapper.compose(form);
        return sendEmail(email);
    }

    /**
     * Send email via Appengine Mail API. If not enough quota, send it via Mailgun.
     *
     * @param email Email to be sent
     * @return Boolean indicating email successfully sent
     */
    private boolean sendEmail(Email email) {
        try {
            email.setFrom(mailApiEmail);
            return mailApi.send(email);
        } catch (ApiProxy.OverQuotaException e) {
            email.setFrom(mailgunEmail);
            return mailgunApi.send(email);
        }
    }
}

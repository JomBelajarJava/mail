package com.jombelajarjava.mail.mailer;

import com.jombelajarjava.mail.mailer.apis.Email;
import com.jombelajarjava.mail.mailer.apis.MailApi;
import com.jombelajarjava.mail.mailer.forms.ContactForm;
import com.jombelajarjava.mail.mailer.utils.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
    @Autowired
    private EmailMapper mapper;

    @Autowired
    private MailApi mailApi;

    /**
     * Compose email from contact form and send it.
     *
     * @param form Contact form
     */
    public void contactUs(ContactForm form) {
        Email email = mapper.compose(form);
        mailApi.send(email);
    }
}

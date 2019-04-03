package com.jombelajarjava.mail.mailer;

import com.jombelajarjava.mail.mailer.apis.MailApiService;
import com.jombelajarjava.mail.mailer.apis.MailgunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MailingService {
    private static final Logger LOG = Logger.getLogger(MailingService.class.getName());

    @Autowired
    private MailApiService mailApiService;

    @Autowired
    private MailgunService mailgunService;

    public void contactUs(Email email) {
//        mailApiService.send(email);
        mailgunService.send(email);
    }
}

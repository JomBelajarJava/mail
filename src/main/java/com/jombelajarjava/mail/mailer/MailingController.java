package com.jombelajarjava.mail.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MailingController {
    @Autowired
    private MailingService mailingService;

    @PostMapping("/mail")
    public void sendEmail(@Valid @RequestBody Email email) {
        mailingService.send(email);
    }
}
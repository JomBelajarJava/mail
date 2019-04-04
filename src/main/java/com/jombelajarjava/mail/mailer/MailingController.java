package com.jombelajarjava.mail.mailer;

import com.jombelajarjava.mail.mailer.forms.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MailingController {
    @Autowired
    private MailingService mailingService;

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public void submitContact(@Valid @ModelAttribute ContactForm form) {
        mailingService.contactUs(form);
    }

    @GetMapping("/donate")
    public String donate() {
        return "donate";
    }

    @PostMapping("/donate")
    public void submitDonate() {

    }
}

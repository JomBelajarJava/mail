package com.jombelajarjava.mail.mailer;

import com.jombelajarjava.mail.mailer.forms.ContactForm;
import com.jombelajarjava.mail.mailer.forms.DonationForm;
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

    /**
     * GET requests.
     */

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/donate")
    public String donate() {
        return "donate";
    }

    /**
     * POST requests.
     */

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute ContactForm form) {
        mailingService.contactUs(form);
        return "success";
    }

    @PostMapping("/donate")
    public String submitDonate(@Valid @ModelAttribute DonationForm form) {
        mailingService.informDonation(form);
        return "success";
    }
}

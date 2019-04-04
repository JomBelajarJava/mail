package com.jombelajarjava.mail.mailer.apis;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
    private String fromName;
    private String fromEmail;
    private String to;
    private String subject;
    private String text;
}

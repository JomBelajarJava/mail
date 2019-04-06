package com.jombelajarjava.mail.mailer.apis;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
    private String from;
    private String to;
    private String subject;
    private String text;
}

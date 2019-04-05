package com.jombelajarjava.mail.mailer.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ContactForm {
    @NotNull(message = "name_null_error")
    @Size(min = 1, max = 100, message = "name_size_error")
    private String name;

    @NotNull(message = "content_null_error")
    @Size(min = 2, max = 2000, message = "content_size_error")
    private String content;

    @Pattern(
            regexp = "(^$|^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)",  // empty string or email
            message = "email_format_error"
    )
    private String email;
}

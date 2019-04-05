package com.jombelajarjava.mail.mailer.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DonationForm {
    @NotNull(message = "name_null_error")
    @Size(min = 1, max = 100, message = "name_size_error")
    private String name;

    @NotNull(message = "message_null_error")
    @Size(max = 2000, message = "message_size_error")
    private String message;

    @NotNull(message = "amount_null_error")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "amount_format_error")
    private String amount;

    @Pattern(
            regexp = "(^$|^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)",  // empty string or email
            message = "email_format_error"
    )
    private String email;
}

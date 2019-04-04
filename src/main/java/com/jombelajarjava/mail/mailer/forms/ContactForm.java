package com.jombelajarjava.mail.mailer.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ContactForm {
    @NotNull(message = "Nama tidak boleh null")
    @Size(min = 1, max = 100, message = "Nama tidak boleh kosong dan tidak melebihi 100 abjad")
    private String name;

    @NotNull(message = "Kandungan email tidak boleh null")
    @Size(min = 2, max = 2000, message = "Kandungan email tidak boleh kosong dan tidak melebihi 2000 abjad")
    private String content;

    @Pattern(
            regexp = "(^$|^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)",  // empty string or email
            message = "Email mesti dalam format email"
    )
    private String from;
}

package com.jombelajarjava.mail.mailer.utils;

import com.jombelajarjava.mail.mailer.forms.ContactForm;

public final class EmailUtils {
    private EmailUtils() {}

    /**
     * Compose email subject depending on whether user entered their email or not.
     *
     * @param form Input form
     * @return Email subject
     */
    public static String composeSubject(ContactForm form) {
        if (form.getEmail() != null && !form.getEmail().isEmpty()) {
            return "[JomBelajarJava] Email dari " + form.getName() + " (" + form.getEmail() + ")";
        } else {
            return "[JomBelajarJava] Email dari " + form.getName();
        }
    }
}

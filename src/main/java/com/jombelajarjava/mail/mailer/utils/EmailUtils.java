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
        if (form.getFrom() != null && !form.getFrom().isEmpty()) {
            return "[JomBelajarJava] Email dari " + form.getName() + " (" + form.getFrom() + ")";
        } else {
            return "[JomBelajarJava] Email dari " + form.getName();
        }
    }
}

package com.jombelajarjava.mail.mailer.utils;

import com.jombelajarjava.mail.mailer.Email;

public final class EmailUtils {
    private EmailUtils() {}

    /**
     * Compose email subject depending on whether user entered their email or not.
     *
     * @param email Input email
     * @return Email subject
     */
    public static String composeSubject(Email email) {
        if (email.getFrom() != null && !email.getFrom().isEmpty()) {
            return "[JomBelajarJava] Email dari " + email.getName() + " (" + email.getFrom() + ")";
        } else {
            return "[JomBelajarJava] Email dari " + email.getName();
        }
    }
}

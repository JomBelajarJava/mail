package com.jombelajarjava.mail.mailer.utils;

import com.jombelajarjava.mail.mailer.forms.ContactForm;
import com.jombelajarjava.mail.mailer.forms.DonationForm;

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

    /**
     * Compose email subject depending on whether user entered their email or not.
     *
     * @param form Input form
     * @return Email subject
     */
    public static String composeSubject(DonationForm form) {
        if (form.getEmail() != null && !form.getEmail().isEmpty()) {
            return "[JomBelajarJava] Sumbangan dari " + form.getName() + " (" + form.getEmail() + ") berjumlah RM " + form.getAmount();
        } else {
            return "[JomBelajarJava] Sumbangan dari " + form.getName() + " berjumlah RM " + form.getAmount();
        }
    }

    /**
     * Compose email body.
     *
     * @param form Input form
     * @return Email body
     */
    public static String composeBody(DonationForm form) {
        return "Nama: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n" +
                "Jumlah sumbangan: RM " + form.getAmount() + "\n" +
                "\n" +
                "Pesanan:" + "\n" +
                "\n" +
                form.getMessage();
    }
}

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
        String currency = form.getMethod().equals("Paypal") ? "$" : "RM";

        if (form.getEmail() != null && !form.getEmail().isEmpty()) {
            return "[JomBelajarJava] Sumbangan dari " + form.getName() + " (" + form.getEmail() + ") " +
                    "berjumlah " + currency + " " + form.getAmount();
        } else {
            return "[JomBelajarJava] Sumbangan dari " + form.getName() + " " +
                    "berjumlah " + currency + " " + form.getAmount();
        }
    }

    /**
     * Compose email body.
     *
     * @param form Input form
     * @return Email body
     */
    public static String composeBody(DonationForm form) {
        String currency = form.getMethod().equals("Paypal") ? "$" : "RM";

        return "Nama: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n" +
                "Sumbangan melalui: " + form.getMethod() + "\n" +
                "Jumlah sumbangan: " + currency + " " + form.getAmount() + "\n" +
                "\n" +
                "Pesanan:" + "\n" +
                "\n" +
                form.getMessage();
    }
}

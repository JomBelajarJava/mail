package com.jombelajarjava.mail.mailer.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Component to call Mailgun API.
 */
@Component
public class MailgunApi {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${mailer.mailgun.baseurl}")
    private String baseUrl;

    @Value("${mailer.mailgun.key}")
    private String apiKey;

    /**
     * Make API call to Mailgun to send the email.
     *
     * @param email Email to be sent
     */
    public void send(Email email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("api", apiKey);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>(4);
        formData.add("from", email.getFromName() + " <" + email.getFromEmail() + ">");
        formData.add("to", email.getTo());
        formData.add("subject", email.getSubject());
        formData.add("text", email.getText());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        restTemplate.postForLocation(baseUrl + "/messages", request);
    }
}

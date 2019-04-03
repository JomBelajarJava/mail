package com.jombelajarjava.mail.mailer.apis;

import com.jombelajarjava.mail.mailer.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.jombelajarjava.mail.mailer.utils.EmailUtils.composeSubject;

/**
 * Service to call Mailgun API.
 */
@Service
public class MailgunService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${mailer.mailgun.baseurl}")
    private String baseUrl;

    @Value("${mailer.mailgun.key}")
    private String apiKey;

    @Value("${mailer.mailgun.email}")
    private String mailgunEmail;

    @Value("${mailer.sender.name}")
    private String senderName;

    @Value("${mailer.admin.email}")
    private String adminEmail;

    /**
     * Make API call to Mailgun to send the email.
     *
     * @param email Email to be sent
     */
    public void send(Email email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("api", apiKey);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>(4);
        formData.add("from", senderName + " <" + mailgunEmail + ">");
        formData.add("to", adminEmail);
        formData.add("subject", composeSubject(email));
        formData.add("text", email.getContent());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        restTemplate.postForLocation(baseUrl + "/messages", request);
    }
}

package com.jombelajarjava.mail.mailer;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice(basePackageClasses = MailingController.class)
public class ConstraintViolationHandler {
    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public String handleInvalidForm(BindException ex, HttpServletRequest request, Model model) {
        model.addAllAttributes(ex.getModel());

        ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(error -> model.addAttribute(error, true));

        String requestUri = ofNullable(request.getRequestURI()).orElse("");

        switch (requestUri) {
            case "/contact": return "contact";
            case "/donate": return "donate";
            default: return null;
        }
    }
}

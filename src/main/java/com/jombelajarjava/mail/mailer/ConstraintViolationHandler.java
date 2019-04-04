package com.jombelajarjava.mail.mailer;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice(basePackageClasses = MailingController.class)
public class ConstraintViolationHandler {
    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public String handleInvalidForm(BindException ex, HttpServletRequest request, Model model) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(Objects::nonNull)
                .sorted()
                .collect(toList());

        model.addAttribute("errors", errors);

        String requestUri = ofNullable(request.getRequestURI()).orElse("");

        switch (requestUri) {
            case "/contact": return "contact";
            case "/donate": return "donate";
            default: return null;
        }
    }
}

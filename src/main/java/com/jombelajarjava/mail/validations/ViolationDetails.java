package com.jombelajarjava.mail.validations;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ViolationDetails {
    private Date timestamp;
    private String message;
    private List<String> details;
}

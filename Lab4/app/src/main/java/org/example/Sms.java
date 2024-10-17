package org.example;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Sms {
    private String phone;
    private String message;
}

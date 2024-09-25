package com.example.moodie.dto.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private Boolean gender; // Female true - Male fale
    private LocalDate dob;
    private String countryCode;
    private String token;
}

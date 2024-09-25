package com.example.moodie.dto.request;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterRequest {
    @Size(min = 1, max = 50, message = "USERNAME_INVALID")
    private String username;

    @Email
    @Size(min = 1, max = 50, message = "EMAIL_INVALID")
    @Nullable
    private String email;

    @Size(min = 10, max = 10, message = "PHONE_INVALID")
    @Nullable
    private String phone;

    @Size(min = 8, max = 20, message = "PASSWORD_INVALID")
    private String password;

    @Nullable
    private Boolean gender; // Female true - Male fale

    @Past
    private LocalDate dob; // Chuyển sang LocalDate

    @Size(min = 2, max = 2)
    @Nullable
    private String countryCode;
}

package com.example.moodie.dto.request;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {
    @Email
    @Nullable
    @Size(min = 1, max = 50, message = "EMAIL_INVALID")
    private String email;

    @Nullable
    @Size(min = 10, max = 10, message = "PHONE_INVALID")
    private String phone;

    @Nonnull
    private String password;
}

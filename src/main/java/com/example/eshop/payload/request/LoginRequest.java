package com.example.eshop.payload.request;

import com.example.eshop.annotations.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotEmpty(message = "Email can't be empty")
    @ValidEmail
    private String email;
    @NotEmpty(message = "Password can't be empty")
    private String password;
}

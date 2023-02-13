package com.example.eshop.payload.request;

import com.example.eshop.annotations.PasswordMatches;
import com.example.eshop.annotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class SignupRequest {
    @Email(message = "Wrong email format")
    @NotBlank(message = "The field can't be blank")
    @ValidEmail
    private String email;
    @NotEmpty(message = "The field can't be blank")
    private String firstName;
    @NotEmpty(message = "The field can't be blank")
    private String lastName;
    @NotEmpty(message = "The field can't be blank")
    @Size(min = 4)
    private String password;
    @NotEmpty(message = "The field can't be blank")
    private String confirmPassword;
}

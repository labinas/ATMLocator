package com.atmlocator.apigateway.model;

/*
    Created by Labina on 30-Jan-22
*/

import com.atmlocator.apigateway.model.validators.PasswordMatches;
import com.atmlocator.apigateway.model.validators.ValidEmail;
import com.atmlocator.apigateway.model.validators.ValidPassword;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@PasswordMatches
public class AuthSignupRequestVO {
    @NotBlank(message = "Enter a username")
    @Size(min = 6, message = "Username should contain at least 6 characters!")
    @Size(max = 30, message = "Username shouldn't contain more than 30 characters!")
    private String username;
    @NotBlank(message = "Enter your e-mail")
    @ValidEmail
    private String email;
    @NotBlank(message = "Enter a password")
    @ValidPassword
    private String password;
    @NotBlank(message = "Re-enter the password to confirm")
    private String matchingPassword;
}

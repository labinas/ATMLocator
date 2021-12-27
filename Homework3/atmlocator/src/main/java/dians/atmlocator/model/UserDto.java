package dians.atmlocator.model;

import dians.atmlocator.model.validators.PasswordMatches;
import dians.atmlocator.model.validators.ValidEmail;
import dians.atmlocator.model.validators.ValidPassword;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@PasswordMatches
public class UserDto {
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

    public UserDto() {
    }

}

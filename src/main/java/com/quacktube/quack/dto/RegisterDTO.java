package com.quacktube.quack.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegisterDTO {

    @NotNull(message = "Username is required")
    String username;

    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    @NotNull(message = "Email is required")
    String email;

    @Size(max = 100, message = "First name must be less than or equal to 100 characters")
    @NotNull(message = "First name is required")
    String firstName;

    @Size(max = 100, message = "Last name must be less than or equal to 100 characters")
    @NotNull(message = "Last name is required")
    String lastName;

    @NotNull(message = "Cover image is required")
    String coverImage;

    @NotNull(message = "Password is required")
    String password;
}

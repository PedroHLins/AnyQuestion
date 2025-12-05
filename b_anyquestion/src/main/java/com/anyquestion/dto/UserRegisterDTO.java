package com.anyquestion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
    @NotBlank(message = "invalid name: blank")
    String name,
    @NotBlank(message = "invalid email: blank")
    @Email(message = "invalid email")
    String email,
    @NotBlank(message = "invalid password: blank")
    @Size(min = 6, message = "invalid password: min=6")
    String password
)
{}

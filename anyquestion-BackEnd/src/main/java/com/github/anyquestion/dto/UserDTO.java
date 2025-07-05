package com.github.anyquestion.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank(message = "The field name don't be empty")
        String name,

        @NotBlank(message = "The field email don't be empty")
        @Email(message = "Invalid email")
        String email,

        @NotBlank(message = "The field password don't be empty")
        @Size(min = 6, message = "The field password need to have minimum 6 characters")
        String password
){}

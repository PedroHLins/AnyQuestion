package com.anyquestion.dto;

import com.anyquestion.models.User;

public record UserResponseDTO(
    Long id,
    String name,
    String email
)
{
    public static UserResponseDTO fromEntity(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
}

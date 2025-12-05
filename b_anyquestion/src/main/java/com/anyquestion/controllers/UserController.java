package com.anyquestion.controllers;

import com.anyquestion.dto.UserRegisterDTO;
import com.anyquestion.dto.UserResponseDTO;
import com.anyquestion.models.User;
import com.anyquestion.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> RegisterUser(@RequestBody @Valid UserRegisterDTO user){
        User newUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.fromEntity(newUser));
    }
}

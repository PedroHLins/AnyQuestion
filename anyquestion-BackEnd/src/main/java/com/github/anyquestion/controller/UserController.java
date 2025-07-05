package com.github.anyquestion.controller;

import com.github.anyquestion.dto.UserDTO;
import com.github.anyquestion.model.User;
import com.github.anyquestion.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    ResponseEntity<String> registerNewUser(@Valid @RequestBody UserDTO userDTO){
        User newUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("user successfully registered, user ID: " + newUser.getId());
    }
}

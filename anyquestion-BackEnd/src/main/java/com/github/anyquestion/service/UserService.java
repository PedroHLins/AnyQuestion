package com.github.anyquestion.service;

import com.github.anyquestion.dto.UserDTO;
import com.github.anyquestion.model.User;
import com.github.anyquestion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(UserDTO userDTO){
        if(userRepository.existsByEmail(userDTO.email())){
            throw new IllegalArgumentException("This email already exists");
        }

        User newUser = new User();
        newUser.setEmail(userDTO.email());
        newUser.setName(userDTO.name());
        String hashPassword = passwordEncoder.encode(userDTO.password());
        newUser.setPassword(hashPassword);
        return userRepository.save(newUser);
    }
}

package com.github.anyquestion.service;

import com.github.anyquestion.dto.UserDTO;
import com.github.anyquestion.model.User;
import com.github.anyquestion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(UserDTO userDTO){
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new RuntimeException();
        }

        User newUser = new User();
        newUser.setEmail(userDTO.getEmail());
        newUser.setName(userDTO.getName());
        newUser.setPassword(userDTO.getPassword());
        userRepository.save(newUser);
    }
}

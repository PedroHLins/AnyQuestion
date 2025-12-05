package com.anyquestion.services;

import com.anyquestion.dto.UserRegisterDTO;
import com.anyquestion.models.User;
import com.anyquestion.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRegisterDTO user) {
        if(userRepository.existsByEmail(user.email())){
            throw new RuntimeException("This email is already in use");
        }

        String passwordHash = passwordEncoder.encode(user.password());

        User newUser = new User();

        newUser.setName(user.name());
        newUser.setEmail(user.email());
        newUser.setPasswordHash(passwordHash);

        return userRepository.save(newUser);
    }
}

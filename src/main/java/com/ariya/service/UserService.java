package com.ariya.service;

import com.ariya.entity.User;
import com.ariya.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean login(String username, String password){

        // Validation
        if(username == null || password == null){
            return false;
        }
        String normalizedUsername = username.toLowerCase();

        return userRepository.findByUsername(normalizedUsername)
                .map(user -> passwordEncoder.matches(
                        password,
                        user.getPasswordHash()
                ))
                .orElse(false);
    }


    public User register(String username, String password) {

        //  Username validation
        String normalizedUsername = username.toLowerCase();
        if (!normalizedUsername.matches("[a-z0-9.]{6,30}")) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (userRepository.findByUsername(normalizedUsername).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Password encoding
        String passwordHash = passwordEncoder.encode(password);
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "Password must be at least 8 characters"
            );
        }

        User user = new User(normalizedUsername, passwordHash);

        return userRepository.save(user);
    }
}

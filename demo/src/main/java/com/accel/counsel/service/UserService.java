package com.accel.counsel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.accel.counsel.model.UserEntity;
import com.accel.counsel.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity registerUser(UserEntity userEntity) {
        if (userRepository.existsByUsername(userEntity.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }
        if (userRepository.existsByEmail(userEntity.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    public UserEntity authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid username or password.");
    }

    public void resetPassword(String email, String newPassword) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Email not found.");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}

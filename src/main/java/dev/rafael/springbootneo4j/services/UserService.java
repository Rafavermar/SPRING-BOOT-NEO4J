package dev.rafael.springbootneo4j.services;

import dev.rafael.springbootneo4j.models.User;
import dev.rafael.springbootneo4j.repositories.UserRepository;
import dev.rafael.springbootneo4j.request.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService( UserRepository userRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {
        // Check if the username already exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return user;
    }

}

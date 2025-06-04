package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.Enum.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Create a new user (can be used by admin or system)
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Sign Up logic
    public User registerUser(String name, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .role(UserRole.STUDENT)
                .build();
        return userRepository.save(user);
    }

    // Sign In logic (returns token or success message)
    public String authenticateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> "Login successful for user: " + user.getName())
                .orElse("Invalid credentials");
    }

    // Update user info
    public User updateUser(Long id, String name, String email, String phone, String bio) {
        return userRepository.findById(id).map(user -> {
            if (name != null) user.setName(name);
            if (email != null) user.setEmail(email);
            if (phone != null) user.setPhone(phone);
            if (bio != null) user.setBio(bio);
            return userRepository.save(user);
        }).orElse(null);
    }

    // Delete user by ID
    public Boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

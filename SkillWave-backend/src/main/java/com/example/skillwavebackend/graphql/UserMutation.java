package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Enum.UserRole;
import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserMutation {
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;



    @MutationMapping
    public User signUp(@Argument String name, @Argument String email, @Argument String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .role(UserRole.STUDENT)
                .build();
        return userRepository.save(user);
    }

    @MutationMapping
    public String signIn(@Argument String email, @Argument String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Here you can generate and return a JWT token (optional)
                return "Login successful for user: " + user.getName();
            }
        }
        return "Invalid credentials";
    }
}

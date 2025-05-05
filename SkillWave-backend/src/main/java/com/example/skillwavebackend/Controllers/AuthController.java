package com.example.skillwavebackend.Controllers;

import com.example.skillwavebackend.Dto.LoginDto;
import com.example.skillwavebackend.Enum.UserRole;
import com.example.skillwavebackend.models.User;
import com.example.skillwavebackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Vérifier si l'email existe déjà
        if (userService.getUserByEmail(user.getEmail()) != null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already in use");
        }

        // Rôle par défaut si non fourni
        if (user.getRole() == null) {
            user.setRole(UserRole.STUDENT);
        }

        User created = userService.createUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }


    // LOGIN (simplifié)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginData) {
        User user = userService.getUserByEmail(loginData.getEmail());
        LoginDto loginDto = new LoginDto();
        loginDto.setId(user.getId());
        loginDto.setEmail(user.getEmail());
        loginDto.setAvatarUrl(user.getAvatarUrl());
        loginDto.setRole(user.getRole().name());
        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(loginDto);
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(loginDto);
    }
}

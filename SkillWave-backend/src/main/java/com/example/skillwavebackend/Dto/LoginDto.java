package com.example.skillwavebackend.Dto;


import com.example.skillwavebackend.Enum.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class LoginDto {



    private Long id;
    private String email;
    private String avatarUrl;
    private String role;
}

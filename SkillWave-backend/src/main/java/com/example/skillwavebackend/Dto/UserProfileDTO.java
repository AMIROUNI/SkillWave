package com.example.skillwavebackend.Dto;

import com.example.skillwavebackend.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {




    private Long id;
    private String fullName;
    private String email;
    private String avatarUrl;
    private String role;
    private String bio;
    private String phone;



}

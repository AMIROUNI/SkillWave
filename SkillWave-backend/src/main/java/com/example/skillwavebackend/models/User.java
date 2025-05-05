package com.example.skillwavebackend.models;
import com.example.skillwavebackend.Enum.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private  String fullName;



    private String email;

    private String password;



    private String avatarUrl;



    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(columnDefinition = "TEXT")
    private String bio;



}

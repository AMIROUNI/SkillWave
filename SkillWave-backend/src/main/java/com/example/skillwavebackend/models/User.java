package com.example.skillwavebackend.models;
import com.example.skillwavebackend.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String fullName;


    @Column(unique = true)
    private String email;

    private String password;



    private String avatarUrl;



    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(columnDefinition = "TEXT")
    private String bio;



}

package com.example.skillwavebackend.models;

import com.example.skillwavebackend.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    private String fullName;

    @Column(unique = true)
    private String email;
    private String password;
    private String avatarUrl;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role; // FREELANCER, CLIENT, ADMIN

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String location;
    private Double hourlyRate;

    @ElementCollection
    private Set<String> skills = new HashSet<>();

    @OneToMany(mappedBy = "freelancer")
    private Set<PortfolioItem> portfolioItems;

    @OneToMany(mappedBy = "client")
    private Set<Project> postedProjects;

    @OneToMany(mappedBy = "freelancer")
    private Set<Bid> bids;
}
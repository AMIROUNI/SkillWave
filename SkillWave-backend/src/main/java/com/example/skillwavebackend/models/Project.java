package com.example.skillwavebackend.models;

import com.example.skillwavebackend.Enum.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private Double budget;
    private String duration;
    private Date deadline;
    private Date postedAt;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status; // OPEN, IN_PROGRESS, COMPLETED, CANCELLED

    @ElementCollection
    private Set<String> requiredSkills;

    @OneToMany(mappedBy = "project")
    private Set<Bid> bids;

    @OneToOne(mappedBy = "project")
    private Contract contract;
}
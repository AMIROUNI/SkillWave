package com.example.skillwavebackend.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    private Double price;

    private String category;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    private Date createdAt;

    private Date updatedAt;
}

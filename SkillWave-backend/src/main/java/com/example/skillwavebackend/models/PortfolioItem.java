package com.example.skillwavebackend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;

    private String title;
    private String description;
    private String imageUrl;
    private String projectUrl;
    private Date completedDate;
}
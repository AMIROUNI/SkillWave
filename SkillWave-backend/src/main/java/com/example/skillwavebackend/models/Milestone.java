package com.example.skillwavebackend.models;

import com.example.skillwavebackend.Enum.MilestoneStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private String title;
    private String description;
    private Double amount;
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private MilestoneStatus status;
}
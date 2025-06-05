package com.example.skillwavebackend.models;

import com.example.skillwavebackend.Enum.ContractStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;

    private Double agreedAmount;
    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private ContractStatus status; // ACTIVE, COMPLETED, TERMINATED

    @OneToMany(mappedBy = "contract")
    private Set<Milestone> milestones;
}
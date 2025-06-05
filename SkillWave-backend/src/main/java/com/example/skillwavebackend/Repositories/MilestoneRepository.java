package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Milestone;
import com.example.skillwavebackend.Enum.MilestoneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    List<Milestone> findByContractId(Long contractId);
    List<Milestone> findByStatus(MilestoneStatus status);
    List<Milestone> findByContractFreelancerId(Long freelancerId);
}
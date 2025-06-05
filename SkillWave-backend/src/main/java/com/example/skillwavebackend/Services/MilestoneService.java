package com.example.skillwavebackend.Services;



import com.example.skillwavebackend.Enum.MilestoneStatus;
import com.example.skillwavebackend.Repositories.MilestoneRepository;
import com.example.skillwavebackend.models.Milestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    // Get all milestones
    public List<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    // Get milestone by ID
    public Optional<Milestone> getMilestoneById(Long id) {
        return milestoneRepository.findById(id);
    }

    // Get milestones by contract ID
    public List<Milestone> getMilestonesByContractId(Long contractId) {
        return milestoneRepository.findByContractId(contractId);
    }

    // Get milestones by freelancer ID
    public List<Milestone> getMilestonesByFreelancerId(Long freelancerId) {
        return milestoneRepository.findByContractFreelancerId(freelancerId);
    }

    // Get milestones by status
    public List<Milestone> getMilestonesByStatus(MilestoneStatus status) {
        return milestoneRepository.findByStatus(status);
    }

    // Create a new milestone
    public Milestone createMilestone(Milestone milestone) {
        milestone.setStatus(MilestoneStatus.PENDING);
        return milestoneRepository.save(milestone);
    }

    // Update milestone
    public Milestone updateMilestone(Long id, Milestone updatedMilestone) {
        return milestoneRepository.findById(id).map(milestone -> {
            if (updatedMilestone.getTitle() != null) milestone.setTitle(updatedMilestone.getTitle());
            if (updatedMilestone.getDescription() != null) milestone.setDescription(updatedMilestone.getDescription());
            if (updatedMilestone.getAmount() != null) milestone.setAmount(updatedMilestone.getAmount());
            if (updatedMilestone.getDueDate() != null) milestone.setDueDate(updatedMilestone.getDueDate());
            if (updatedMilestone.getStatus() != null) milestone.setStatus(updatedMilestone.getStatus());
            return milestoneRepository.save(milestone);
        }).orElse(null);
    }

    // Delete milestone
    public boolean deleteMilestone(Long id) {
        if (milestoneRepository.existsById(id)) {
            milestoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
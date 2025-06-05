package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Enum.BidStatus;
import com.example.skillwavebackend.Repositories.BidRepository;
import com.example.skillwavebackend.models.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    // Get all bids
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    // Get bid by ID
    public Optional<Bid> getBidById(Long id) {
        return bidRepository.findById(id);
    }

    // Get bids by project ID
    public List<Bid> getBidsByProjectId(Long projectId) {
        return bidRepository.findByProjectId(projectId);
    }

    // Get bids by freelancer ID
    public List<Bid> getBidsByFreelancerId(Long freelancerId) {
        return bidRepository.findByFreelancerId(freelancerId);
    }

    // Get bids by status
    public List<Bid> getBidsByStatus(BidStatus status) {
        return bidRepository.findByStatus(status);
    }

    // Check if freelancer already bid on project
    public boolean hasFreelancerBid(Long projectId, Long freelancerId) {
        return bidRepository.existsByProjectIdAndFreelancerId(projectId, freelancerId);
    }

    // Create a new bid
    public Bid createBid(Bid bid) {
        bid.setSubmittedAt(new Date());
        bid.setStatus(BidStatus.PENDING);
        return bidRepository.save(bid);
    }

    // Update bid
    public Bid updateBid(Long id, Bid updatedBid) {
        return bidRepository.findById(id).map(bid -> {
            if (updatedBid.getAmount() != null) bid.setAmount(updatedBid.getAmount());
            if (updatedBid.getProposal() != null) bid.setProposal(updatedBid.getProposal());
            if (updatedBid.getDeliveryDays() != null) bid.setDeliveryDays(updatedBid.getDeliveryDays());
            if (updatedBid.getStatus() != null) bid.setStatus(updatedBid.getStatus());
            return bidRepository.save(bid);
        }).orElse(null);
    }

    // Delete bid
    public boolean deleteBid(Long id) {
        if (bidRepository.existsById(id)) {
            bidRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
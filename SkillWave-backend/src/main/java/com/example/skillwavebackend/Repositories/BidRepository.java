package com.example.skillwavebackend.Repositories;



import com.example.skillwavebackend.models.Bid;
import com.example.skillwavebackend.Enum.BidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByProjectId(Long projectId);
    List<Bid> findByFreelancerId(Long freelancerId);
    List<Bid> findByStatus(BidStatus status);
    boolean existsByProjectIdAndFreelancerId(Long projectId, Long freelancerId);
}
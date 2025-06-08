package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    List<PortfolioItem> findByFreelancerId(Long freelancerId);
    List<PortfolioItem> findByTitleContainingIgnoreCase(String keyword);


}
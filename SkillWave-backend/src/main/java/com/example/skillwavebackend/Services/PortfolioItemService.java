package com.example.skillwavebackend.Services;



import com.example.skillwavebackend.Repositories.PortfolioItemRepository;
import com.example.skillwavebackend.models.PortfolioItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioItemService {

    @Autowired
    private PortfolioItemRepository portfolioItemRepository;

    // Get all portfolio items
    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioItemRepository.findAll();
    }

    // Get portfolio item by ID
    public Optional<PortfolioItem> getPortfolioItemById(Long id) {
        return portfolioItemRepository.findById(id);
    }

    // Get portfolio items by freelancer ID
    public List<PortfolioItem> getPortfolioItemsByFreelancerId(Long freelancerId) {
        return portfolioItemRepository.findByFreelancerId(freelancerId);
    }

    // Search portfolio items by title
    public List<PortfolioItem> searchPortfolioItemsByTitle(String keyword) {
        return portfolioItemRepository.findByTitleContainingIgnoreCase(keyword);
    }

    // Create a new portfolio item
    public PortfolioItem createPortfolioItem(PortfolioItem portfolioItem) {
        portfolioItem.setCompletedDate(new Date());
        return portfolioItemRepository.save(portfolioItem);
    }

    // Update portfolio item
    public PortfolioItem updatePortfolioItem(Long id, PortfolioItem updatedPortfolioItem) {
        return portfolioItemRepository.findById(id).map(portfolioItem -> {
            if (updatedPortfolioItem.getTitle() != null) portfolioItem.setTitle(updatedPortfolioItem.getTitle());
            if (updatedPortfolioItem.getDescription() != null) portfolioItem.setDescription(updatedPortfolioItem.getDescription());
            if (updatedPortfolioItem.getImageUrl() != null) portfolioItem.setImageUrl(updatedPortfolioItem.getImageUrl());
            if (updatedPortfolioItem.getProjectUrl() != null) portfolioItem.setProjectUrl(updatedPortfolioItem.getProjectUrl());
            return portfolioItemRepository.save(portfolioItem);
        }).orElse(null);
    }

    // Delete portfolio item
    public boolean deletePortfolioItem(Long id) {
        if (portfolioItemRepository.existsById(id)) {
            portfolioItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
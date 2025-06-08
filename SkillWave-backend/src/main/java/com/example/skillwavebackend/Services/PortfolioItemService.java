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

    public List<PortfolioItem> getAllItems() {
        return portfolioItemRepository.findAll();
    }

    public Optional<PortfolioItem> getItemById(Long id) {
        return portfolioItemRepository.findById(id);
    }

    public List<PortfolioItem> getItemsByFreelancerId(Long freelancerId) {
        return portfolioItemRepository.findByFreelancerId(freelancerId);
    }

    public PortfolioItem createItem(PortfolioItem item) {
        item.setCompletedDate(new Date()); // Set current date
        return portfolioItemRepository.save(item);
    }

    public PortfolioItem updateItem(Long id, PortfolioItem updatedItem) {
        return portfolioItemRepository.findById(id).map(item -> {
            if (updatedItem.getTitle() != null) item.setTitle(updatedItem.getTitle());
            if (updatedItem.getDescription() != null) item.setDescription(updatedItem.getDescription());
            if (updatedItem.getImageUrl() != null) item.setImageUrl(updatedItem.getImageUrl());
            if (updatedItem.getProjectUrl() != null) item.setProjectUrl(updatedItem.getProjectUrl());
            return portfolioItemRepository.save(item);
        }).orElse(null);
    }

    public boolean deleteItem(Long id) {
        if (portfolioItemRepository.existsById(id)) {
            portfolioItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

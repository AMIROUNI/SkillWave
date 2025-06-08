package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.Services.PortfolioItemService;
import com.example.skillwavebackend.models.PortfolioItem;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class PortfolioItemResolver {

    @Autowired
    private PortfolioItemService portfolioItemService;

    @Autowired
    private UserRepository userRepository;

    @SchemaMapping(typeName = "Query", field = "getAllPortfolioItems")
    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioItemService.getAllItems();
    }

    @SchemaMapping(typeName = "Query", field = "getPortfolioItemById")
    public PortfolioItem getPortfolioItemById(@Argument Long id) {
        return portfolioItemService.getItemById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getPortfolioItemsByFreelancerId")
    public List<PortfolioItem> getPortfolioItemsByFreelancerId(@Argument Long freelancerId) {
        return portfolioItemService.getItemsByFreelancerId(freelancerId);
    }

    @SchemaMapping(typeName = "Mutation", field = "createPortfolioItem")
    public PortfolioItem createPortfolioItem(
            @Argument String title,
            @Argument String description,
            @Argument String imageUrl,
            @Argument String projectUrl,
            @Argument Long freelancerId
    ) {
        User freelancer = userRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Freelancer not found"));

        PortfolioItem item = new PortfolioItem();
        item.setTitle(title);
        item.setDescription(description);
        item.setImageUrl(imageUrl);
        item.setProjectUrl(projectUrl);
        item.setFreelancer(freelancer);
        item.setCompletedDate(new Date());

        return portfolioItemService.createItem(item);
    }

    @SchemaMapping(typeName = "Mutation", field = "updatePortfolioItem")
    public PortfolioItem updatePortfolioItem(
            @Argument Long id,
            @Argument String title,
            @Argument String description,
            @Argument String imageUrl,
            @Argument String projectUrl
    ) {
        PortfolioItem item = new PortfolioItem();
        item.setTitle(title);
        item.setDescription(description);
        item.setImageUrl(imageUrl);
        item.setProjectUrl(projectUrl);
        return portfolioItemService.updateItem(id, item);
    }

    @SchemaMapping(typeName = "Mutation", field = "deletePortfolioItem")
    public Boolean deletePortfolioItem(@Argument Long id) {
        return portfolioItemService.deleteItem(id);
    }
}

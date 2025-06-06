package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Enum.BidStatus;
import com.example.skillwavebackend.Services.BidService;
import com.example.skillwavebackend.Repositories.ProjectRepository;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.Bid;
import com.example.skillwavebackend.models.Project;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class BidResolver {

    @Autowired
    private BidService bidService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @SchemaMapping(typeName = "Query", field = "getAllBids")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @SchemaMapping(typeName = "Query", field = "getBidById")
    public Bid getBidById(@Argument Long id) {
        return bidService.getBidById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getBidsByProjectId")
    public List<Bid> getBidsByProjectId(@Argument Long projectId) {
        return bidService.getBidsByProjectId(projectId);
    }

    @SchemaMapping(typeName = "Query", field = "getBidsByFreelancerId")
    public List<Bid> getBidsByFreelancerId(@Argument Long freelancerId) {
        return bidService.getBidsByFreelancerId(freelancerId);
    }

    @SchemaMapping(typeName = "Query", field = "getBidsByStatus")
    public List<Bid> getBidsByStatus(@Argument String status) {
        return bidService.getBidsByStatus(BidStatus.valueOf(status));
    }

    @SchemaMapping(typeName = "Query", field = "hasFreelancerBid")
    public Boolean hasFreelancerBid(@Argument Long projectId, @Argument Long freelancerId) {
        return bidService.hasFreelancerBid(projectId, freelancerId);
    }

    @SchemaMapping(typeName = "Mutation", field = "createBid")
    public Bid createBid(
            @Argument Long projectId,
            @Argument Long freelancerId,
            @Argument Double amount,
            @Argument String proposal,
            @Argument Integer deliveryDays
    ) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User freelancer = userRepository.findById(freelancerId).orElse(null);

        if (project == null || freelancer == null) {
            throw new RuntimeException("Invalid project or freelancer ID");
        }

        Bid bid = new Bid();
        bid.setProject(project);
        bid.setFreelancer(freelancer);
        bid.setAmount(amount);
        bid.setProposal(proposal);
        bid.setDeliveryDays(deliveryDays);

        return bidService.createBid(bid);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateBid")
    public Bid updateBid(
            @Argument Long id,
            @Argument Double amount,
            @Argument String proposal,
            @Argument Integer deliveryDays,
            @Argument String status
    ) {
        Bid updated = new Bid();
        updated.setAmount(amount);
        updated.setProposal(proposal);
        updated.setDeliveryDays(deliveryDays);
        updated.setStatus(status != null ? BidStatus.valueOf(status) : null);

        return bidService.updateBid(id, updated);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteBid")
    public Boolean deleteBid(@Argument Long id) {
        return bidService.deleteBid(id);
    }
}

package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Enum.MilestoneStatus;
import com.example.skillwavebackend.Services.MilestoneService;
import com.example.skillwavebackend.models.Milestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MilestoneResolver {

    @Autowired
    private MilestoneService milestoneService;

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    @SchemaMapping(typeName = "Query", field = "getAllMilestones")
    public List<Milestone> getAllMilestones() {
        return milestoneService.getAllMilestones();
    }

    @SchemaMapping(typeName = "Query", field = "getMilestoneById")
    public Milestone getMilestoneById(@Argument Long id) {
        return milestoneService.getMilestoneById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getMilestonesByContractId")
    public List<Milestone> getMilestonesByContractId(@Argument Long contractId) {
        return milestoneService.getMilestonesByContractId(contractId);
    }

    @SchemaMapping(typeName = "Query", field = "getMilestonesByFreelancerId")
    public List<Milestone> getMilestonesByFreelancerId(@Argument Long freelancerId) {
        return milestoneService.getMilestonesByFreelancerId(freelancerId);
    }

    @SchemaMapping(typeName = "Query", field = "getMilestonesByStatus")
    public List<Milestone> getMilestonesByStatus(@Argument String status) {
        return milestoneService.getMilestonesByStatus(MilestoneStatus.valueOf(status));
    }

    @SchemaMapping(typeName = "Mutation", field = "createMilestone")
    public Milestone createMilestone(
            @Argument Long contractId,
            @Argument String title,
            @Argument String description,
            @Argument Double amount,
            @Argument String dueDate
    ) {
        Milestone milestone = new Milestone();
        milestone.setContract(new com.example.skillwavebackend.models.Contract());
        milestone.getContract().setId(contractId);
        milestone.setTitle(title);
        milestone.setDescription(description);
        milestone.setAmount(amount);
        milestone.setDueDate(parseDate(dueDate));
        return milestoneService.createMilestone(milestone);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateMilestone")
    public Milestone updateMilestone(
            @Argument Long id,
            @Argument String title,
            @Argument String description,
            @Argument Double amount,
            @Argument String dueDate,
            @Argument String status
    ) {
        Milestone updatedMilestone = new Milestone();
        updatedMilestone.setTitle(title);
        updatedMilestone.setDescription(description);
        updatedMilestone.setAmount(amount);
        updatedMilestone.setDueDate(parseDate(dueDate));
        if (status != null) updatedMilestone.setStatus(MilestoneStatus.valueOf(status));
        return milestoneService.updateMilestone(id, updatedMilestone);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteMilestone")
    public Boolean deleteMilestone(@Argument Long id) {
        return milestoneService.deleteMilestone(id);
    }
}

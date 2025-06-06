package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Enum.ContractStatus;
import com.example.skillwavebackend.Services.ContractService;
import com.example.skillwavebackend.Repositories.ProjectRepository;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.Contract;
import com.example.skillwavebackend.models.Project;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ContractResolver {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    @SchemaMapping(typeName = "Query", field = "getAllContracts")
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @SchemaMapping(typeName = "Query", field = "getContractById")
    public Contract getContractById(@Argument Long id) {
        return contractService.getContractById(id).orElse(null);
    }

    @SchemaMapping(typeName = "Query", field = "getContractsByFreelancerId")
    public List<Contract> getContractsByFreelancerId(@Argument Long freelancerId) {
        return contractService.getContractsByFreelancerId(freelancerId);
    }

    @SchemaMapping(typeName = "Query", field = "getContractsByClientId")
    public List<Contract> getContractsByClientId(@Argument Long clientId) {
        return contractService.getContractsByClientId(clientId);
    }

    @SchemaMapping(typeName = "Query", field = "getContractsByStatus")
    public List<Contract> getContractsByStatus(@Argument String status) {
        return contractService.getContractsByStatus(ContractStatus.valueOf(status));
    }

    @SchemaMapping(typeName = "Query", field = "getContractByProjectId")
    public Contract getContractByProjectId(@Argument Long projectId) {
        return contractService.getContractByProjectId(projectId).orElse(null);
    }

    @SchemaMapping(typeName = "Mutation", field = "createContract")
    public Contract createContract(
            @Argument Long projectId,
            @Argument Long freelancerId,
            @Argument Double agreedAmount
    ) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User freelancer = userRepository.findById(freelancerId).orElse(null);

        if (project == null || freelancer == null) {
            throw new RuntimeException("Invalid project or freelancer ID");
        }

        Contract contract = new Contract();
        contract.setProject(project);
        contract.setFreelancer(freelancer);
        contract.setAgreedAmount(agreedAmount);
        // startDate and status are automatically set in the service
        return contractService.createContract(contract);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateContract")
    public Contract updateContract(
            @Argument Long id,
            @Argument Double agreedAmount,
            @Argument String endDate,
            @Argument String status
    ) {
        Contract updatedContract = new Contract();
        updatedContract.setAgreedAmount(agreedAmount);
        updatedContract.setEndDate(parseDate(endDate));
        updatedContract.setStatus(status != null ? ContractStatus.valueOf(status) : null);

        return contractService.updateContract(id, updatedContract);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteContract")
    public Boolean deleteContract(@Argument Long id) {
        return contractService.deleteContract(id);
    }
}

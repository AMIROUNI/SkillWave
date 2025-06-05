package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Enum.ContractStatus;
import com.example.skillwavebackend.Repositories.ContractRepository;
import com.example.skillwavebackend.models.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    // Get all contracts
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    // Get contract by ID
    public Optional<Contract> getContractById(Long id) {
        return contractRepository.findById(id);
    }

    // Get contracts by freelancer ID
    public List<Contract> getContractsByFreelancerId(Long freelancerId) {
        return contractRepository.findByFreelancerId(freelancerId);
    }

    // Get contracts by client ID
    public List<Contract> getContractsByClientId(Long clientId) {
        return contractRepository.findByProjectClientId(clientId);
    }

    // Get contracts by status
    public List<Contract> getContractsByStatus(ContractStatus status) {
        return contractRepository.findByStatus(status);
    }

    // Get contract by project ID
    public Optional<Contract> getContractByProjectId(Long projectId) {
        return contractRepository.findByProjectId(projectId);
    }

    // Create a new contract
    public Contract createContract(Contract contract) {
        contract.setStartDate(new Date());
        contract.setStatus(ContractStatus.ACTIVE);
        return contractRepository.save(contract);
    }

    // Update contract
    public Contract updateContract(Long id, Contract updatedContract) {
        return contractRepository.findById(id).map(contract -> {
            if (updatedContract.getAgreedAmount() != null) contract.setAgreedAmount(updatedContract.getAgreedAmount());
            if (updatedContract.getEndDate() != null) contract.setEndDate(updatedContract.getEndDate());
            if (updatedContract.getStatus() != null) contract.setStatus(updatedContract.getStatus());
            return contractRepository.save(contract);
        }).orElse(null);
    }

    // Delete contract
    public boolean deleteContract(Long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
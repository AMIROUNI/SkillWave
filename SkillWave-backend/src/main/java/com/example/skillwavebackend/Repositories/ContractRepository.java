package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Contract;
import com.example.skillwavebackend.Enum.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByFreelancerId(Long freelancerId);
    List<Contract> findByProjectClientId(Long clientId);
    List<Contract> findByStatus(ContractStatus status);
    Optional<Contract> findByProjectId(Long projectId);
}
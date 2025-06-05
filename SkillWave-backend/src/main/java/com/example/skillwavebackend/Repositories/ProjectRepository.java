package com.example.skillwavebackend.Repositories;

import com.example.skillwavebackend.models.Project;
import com.example.skillwavebackend.Enum.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByClientId(Long clientId);
    List<Project> findByStatus(ProjectStatus status);
    List<Project> findByRequiredSkillsContaining(String skill);
    List<Project> findByBudgetBetween(Double min, Double max);
}
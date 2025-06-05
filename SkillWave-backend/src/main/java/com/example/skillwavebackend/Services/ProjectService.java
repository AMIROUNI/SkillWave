package com.example.skillwavebackend.Services;


import com.example.skillwavebackend.Enum.ProjectStatus;
import com.example.skillwavebackend.Repositories.ProjectRepository;
import com.example.skillwavebackend.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get project by ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Get projects by client ID
    public List<Project> getProjectsByClientId(Long clientId) {
        return projectRepository.findByClientId(clientId);
    }

    // Get projects by status
    public List<Project> getProjectsByStatus(ProjectStatus status) {
        return projectRepository.findByStatus(status);
    }

    // Get projects by required skill
    public List<Project> getProjectsBySkill(String skill) {
        return projectRepository.findByRequiredSkillsContaining(skill);
    }

    // Get projects by budget range
    public List<Project> getProjectsByBudgetRange(Double min, Double max) {
        return projectRepository.findByBudgetBetween(min, max);
    }

    // Create a new project
    public Project createProject(Project project) {
        project.setPostedAt(new Date());
        project.setStatus(ProjectStatus.OPEN);
        return projectRepository.save(project);
    }

    // Update project
    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id).map(project -> {
            if (updatedProject.getTitle() != null) project.setTitle(updatedProject.getTitle());
            if (updatedProject.getDescription() != null) project.setDescription(updatedProject.getDescription());
            if (updatedProject.getBudget() != null) project.setBudget(updatedProject.getBudget());
            if (updatedProject.getDuration() != null) project.setDuration(updatedProject.getDuration());
            if (updatedProject.getDeadline() != null) project.setDeadline(updatedProject.getDeadline());
            if (updatedProject.getRequiredSkills() != null) project.setRequiredSkills(updatedProject.getRequiredSkills());
            if (updatedProject.getStatus() != null) project.setStatus(updatedProject.getStatus());
            return projectRepository.save(project);
        }).orElse(null);
    }

    // Delete project
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
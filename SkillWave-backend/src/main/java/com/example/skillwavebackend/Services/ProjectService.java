package com.example.skillwavebackend.Services;

import com.example.skillwavebackend.Enum.ProjectStatus;
import com.example.skillwavebackend.Repositories.ProjectRepository;
import com.example.skillwavebackend.Repositories.UserRepository;
import com.example.skillwavebackend.models.Project;
import com.example.skillwavebackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Project addProject(String title, String description, Long clientId,
                              Double budget, String duration, Date deadline,
                              Date postedAt, ProjectStatus status, Set<String> requiredSkills) {

        User client = userRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));

        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setClient(client);
        project.setBudget(budget);
        project.setDuration(duration);
        project.setDeadline(deadline);
        project.setPostedAt(postedAt);
        project.setStatus(status);
        project.setRequiredSkills(requiredSkills);

        return projectRepository.save(project);
    }

    public Project updateProject(Long id, String title, String description, Double budget,
                                 String duration, Date deadline, ProjectStatus status,
                                 Set<String> requiredSkills) {
        return projectRepository.findById(id).map(project -> {
            if (title != null) project.setTitle(title);
            if (description != null) project.setDescription(description);
            if (budget != null) project.setBudget(budget);
            if (duration != null) project.setDuration(duration);
            if (deadline != null) project.setDeadline(deadline);
            if (status != null) project.setStatus(status);
            if (requiredSkills != null) project.setRequiredSkills(requiredSkills);
            return projectRepository.save(project);
        }).orElse(null);
    }

    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}

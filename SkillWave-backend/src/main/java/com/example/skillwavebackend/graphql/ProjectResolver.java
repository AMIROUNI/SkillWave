package com.example.skillwavebackend.graphql;

import com.example.skillwavebackend.Enum.ProjectStatus;
import com.example.skillwavebackend.Services.ProjectService;
import com.example.skillwavebackend.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class ProjectResolver {

    @Autowired
    private ProjectService projectService;

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    @SchemaMapping(typeName = "Query", field = "getProjectById")
    public Project getProjectById(@Argument Long id) {
        return projectService.getProjectById(id);
    }

    @SchemaMapping(typeName = "Query", field = "getAllProjects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @SchemaMapping(typeName = "Mutation", field = "addProject")
    public Project addProject(
            @Argument String title,
            @Argument String description,
            @Argument Long clientId,
            @Argument Double budget,
            @Argument String duration,
            @Argument String deadline,
            @Argument String postedAt,
            @Argument String status,
            @Argument Set<String> requiredSkills
    ) {
        return projectService.addProject(
                title, description, clientId, budget, duration,
                parseDate(deadline), parseDate(postedAt),
                ProjectStatus.valueOf(status), requiredSkills
        );
    }

    @SchemaMapping(typeName = "Mutation", field = "updateProject")
    public Project updateProject(
            @Argument Long id,
            @Argument String title,
            @Argument String description,
            @Argument Double budget,
            @Argument String duration,
            @Argument String deadline,
            @Argument String status,
            @Argument Set<String> requiredSkills
    ) {
        return projectService.updateProject(
                id, title, description, budget, duration,
                parseDate(deadline),
                status != null ? ProjectStatus.valueOf(status) : null,
                requiredSkills
        );
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteProject")
    public Boolean deleteProject(@Argument Long id) {
        return projectService.deleteProject(id);
    }
}

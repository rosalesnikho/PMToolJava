package io.pmtool.pmtool.services;

import io.pmtool.pmtool.domain.Project;
import io.pmtool.pmtool.exceptions.ProjectIdException;
import io.pmtool.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // Save new projects
    // If the project ID already exists in the db, throws an error to the user
    public Project saveOrUpdateProject (Project project) {
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e) {
            throw new ProjectIdException("Project ID: " + project.getProjectIdentifier().toUpperCase() + " already exist!");
        }
    }

    // Get Project by unique identifier
    // If the project is null, throws a custom error message to user
    public Project findProjectByIdentifier(String projectId) {
        Project project  = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null) {
            throw new ProjectIdException("Project " + projectId.toUpperCase() + " does not exist!");
        }
        return project;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier (String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null) {
            throw new ProjectIdException("Project " + projectId.toUpperCase() + " does not exist!");
        }
        projectRepository.delete(project);

    }
}


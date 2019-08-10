package io.pmtool.pmtool.services;

import io.pmtool.pmtool.domain.Project;
import io.pmtool.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject (Project project) {
        return projectRepository.save(project);
    }
}


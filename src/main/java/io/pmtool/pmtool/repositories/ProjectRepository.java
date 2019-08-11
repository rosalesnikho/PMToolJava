package io.pmtool.pmtool.repositories;
import io.pmtool.pmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    // Project Search
    @Override
    Iterable<Project> findAll();

    // finds a project by project identifier
    Project findByProjectIdentifier (String projectId);

}

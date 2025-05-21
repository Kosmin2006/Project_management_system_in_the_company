package ua.opnu.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.management_system.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

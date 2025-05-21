package ua.opnu.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.management_system.project.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByAssigneeId(Long employeeId);
    List<Task> findByStatus(String status);
}

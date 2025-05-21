package ua.opnu.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.management_system.project.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByEmployeeId(Long employeeId);
}

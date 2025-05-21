package ua.opnu.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.management_system.project.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

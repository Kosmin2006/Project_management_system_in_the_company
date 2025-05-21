package ua.opnu.management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Employee;
import ua.opnu.management_system.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id)
                .map(emp -> {
                    emp.setName(updated.getName());
                    emp.setPosition(updated.getPosition());
                    emp.setEmail(updated.getEmail());
                    return employeeRepository.save(emp);
                })
                .orElseThrow(() -> new RuntimeException("Працівника не знайдено"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

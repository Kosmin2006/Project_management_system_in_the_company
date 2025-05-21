package ua.opnu.management_system.service;

import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Assignment;
import ua.opnu.management_system.repository.AssignmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment create(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getById(Long id) {
        return assignmentRepository.findById(id);
    }

    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> getByProjectId(Long projectId) {
        return assignmentRepository.findByProjectId(projectId);
    }

    public List<Assignment> getByEmployeeId(Long employeeId) {
        return assignmentRepository.findByEmployeeId(employeeId);
    }
}

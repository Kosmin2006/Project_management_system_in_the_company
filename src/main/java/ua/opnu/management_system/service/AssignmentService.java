package ua.opnu.management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Assignment;
import ua.opnu.management_system.repository.AssignmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public Assignment assignEmployeeToProject(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByEmployeeId(Long employeeId) {
        return assignmentRepository.findByEmployeeId(employeeId);
    }

    public List<Assignment> getAssignmentsByProjectId(Long projectId) {
        return assignmentRepository.findByProjectId(projectId);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}

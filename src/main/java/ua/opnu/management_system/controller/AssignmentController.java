package ua.opnu.management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.management_system.project.Assignment;
import ua.opnu.management_system.service.AssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // 14. Призначити працівника на проєкт
    @PostMapping
    public ResponseEntity<Assignment> assign(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.assignEmployeeToProject(assignment));
    }

    // 15. Отримати команду проєкту (Assignment як участь у команді)
    @GetMapping("/by-project/{projectId}")
    public ResponseEntity<List<Assignment>> getByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByProjectId(projectId));
    }

    // 16. Отримати всі проєкти працівника
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<Assignment>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByEmployeeId(employeeId));
    }

    // Видалити assignment (додатково)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}

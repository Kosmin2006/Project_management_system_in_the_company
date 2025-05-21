package ua.opnu.management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.management_system.project.Assignment;
import ua.opnu.management_system.service.AssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // Призначити працівника на проєкт (створити Assignment)
    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.create(assignment));
    }

    // Отримати призначення за id
    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        return assignmentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Видалити призначення
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        if (assignmentService.getById(id).isPresent()) {
            assignmentService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Отримати всі призначення працівника
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Assignment>> getAssignmentsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(assignmentService.getByEmployeeId(employeeId));
    }

    // Отримати всі призначення проєкту
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Assignment>> getAssignmentsByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(assignmentService.getByProjectId(projectId));
    }
}

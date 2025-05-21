package ua.opnu.management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.management_system.project.Task;
import ua.opnu.management_system.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Створити нову задачу
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.create(task));
    }

    // Отримати задачу за id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Оновити задачу
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.getById(id)
                .map(existingTask -> {
                    task.setId(id);
                    return ResponseEntity.ok(taskService.update(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Видалити задачу
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.getById(id).isPresent()) {
            taskService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Отримати задачі проєкту
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Task>> getTasksByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(taskService.getByProjectId(projectId));
    }

    // Отримати задачі працівника
    @GetMapping("/assignee/{employeeId}")
    public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(taskService.getByAssigneeId(employeeId));
    }

    // Отримати список задач у статусі "виконується"
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        return ResponseEntity.ok(taskService.getByStatus(status));
    }
}

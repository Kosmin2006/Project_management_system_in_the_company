package ua.opnu.management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Task;
import ua.opnu.management_system.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public List<Task> getTasksByEmployeeId(Long employeeId) {
        return taskRepository.findByAssigneeId(employeeId);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    task.setAssignee(updatedTask.getAssignee());
                    task.setProject(updatedTask.getProject());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Задачу не знайдено"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

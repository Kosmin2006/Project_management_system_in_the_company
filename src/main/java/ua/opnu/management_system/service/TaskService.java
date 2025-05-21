package ua.opnu.management_system.service;

import org.springframework.stereotype.Service;
import ua.opnu.management_system.project.Task;
import ua.opnu.management_system.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public List<Task> getByAssigneeId(Long employeeId) {
        return taskRepository.findByAssigneeId(employeeId);
    }

    public List<Task> getByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}

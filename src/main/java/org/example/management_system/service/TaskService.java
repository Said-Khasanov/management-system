package org.example.management_system.service;

import lombok.RequiredArgsConstructor;
import org.example.management_system.dto.TaskRequestTo;
import org.example.management_system.dto.TaskResponseTo;
import org.example.management_system.entity.Task;
import org.example.management_system.entity.User;
import org.example.management_system.mapper.TaskMapper;
import org.example.management_system.repository.TaskRepository;
import org.example.management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    public List<TaskResponseTo> findAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(taskMapper::toResponseTo)
                .toList();
    }

    public TaskResponseTo findById(Long id) {
        return taskMapper.toResponseTo(getExisting(id));
    }

    public TaskResponseTo save(TaskRequestTo taskRequestTo) {
        Task task = taskMapper.toEntity(taskRequestTo);
        task = taskRepository.save(task);
        return taskMapper.toResponseTo(task);
    }

    public TaskResponseTo update(Long id, TaskRequestTo taskRequestTo) {
        Task task = getExisting(id);
        task.setTitle(taskRequestTo.getTitle());
        task.setDescription(taskRequestTo.getDescription());
        task.setStatus(taskRequestTo.getStatus());
        task.setPriority(taskRequestTo.getPriority());
        task.setComments(taskRequestTo.getComments());
        User author = getExistingUser(taskRequestTo.getAuthorId());
        task.setAuthor(author);
        User executor = getExistingUser(taskRequestTo.getExecutorId());
        task.setExecutor(executor);
        task = taskRepository.save(task);
        return taskMapper.toResponseTo(task);
    }

    public void deleteById(Long id) {
        getExisting(id);
        taskRepository.deleteById(id);
    }

    private Task getExisting(Long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    private User getExistingUser(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
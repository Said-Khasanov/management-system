package org.example.management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.management_system.dto.TaskRequestTo;
import org.example.management_system.dto.TaskResponseTo;
import org.example.management_system.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseTo>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<TaskResponseTo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponseTo> create(@RequestBody TaskRequestTo taskRequestTo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskRequestTo));
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<TaskResponseTo> update(@PathVariable Long id, @RequestBody TaskRequestTo taskRequestTo) {
        return ResponseEntity.ok(taskService.update(id, taskRequestTo));
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

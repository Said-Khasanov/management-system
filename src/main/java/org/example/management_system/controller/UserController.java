package org.example.management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.management_system.dto.UserRequestTo;
import org.example.management_system.dto.UserResponseTo;
import org.example.management_system.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseTo>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<UserResponseTo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseTo> save(UserRequestTo userRequestTo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequestTo));
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<UserResponseTo> update(@PathVariable Long id, UserRequestTo userRequestTo) {
        return ResponseEntity.ok(userService.update(id, userRequestTo));
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

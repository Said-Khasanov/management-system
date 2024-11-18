package org.example.management_system.service;

import lombok.RequiredArgsConstructor;
import org.example.management_system.dto.UserRequestTo;
import org.example.management_system.dto.UserResponseTo;
import org.example.management_system.entity.User;
import org.example.management_system.mapper.UserMapper;
import org.example.management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseTo> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toResponseTo)
                .toList();
    }

    public UserResponseTo findById(Long id) {
        return userMapper.toResponseTo(getExisting(id));
    }

    public UserResponseTo save(UserRequestTo userRequestTo) {
        User user = userMapper.toEntity(userRequestTo);
        user = userRepository.save(user);
        return userMapper.toResponseTo(user);
    }

    public UserResponseTo update(Long id, UserRequestTo userRequestTo) {
        User user = getExisting(id);
        user.setEmail(userRequestTo.getEmail());
        user.setPassword(userRequestTo.getPassword());
        user = userRepository.save(user);
        return userMapper.toResponseTo(user);
    }

    public void deleteById(Long id) {
        getExisting(id);
        userRepository.deleteById(id);
    }

    private User getExisting(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}

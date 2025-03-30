package org.example.service;

import org.example.dao.UserRepository;
import org.example.model.User;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return userRepository.findById(id);
    }

    public boolean createUser(User user) {
        if (user == null || user.getEmail() == null || user.getName() == null) {
            throw new IllegalArgumentException("User details cannot be null");
        }
        return userRepository.save(user);
    }
}

package org.example.dao;

import org.example.model.User;

public interface UserRepository {
    User findById(Long id);
    boolean save(User user);
}

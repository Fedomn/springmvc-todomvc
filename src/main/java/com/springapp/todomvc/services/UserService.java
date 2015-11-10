package com.springapp.todomvc.services;

import com.springapp.todomvc.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User save(User newUser);

    void deleteById(String id);

    User findOne(String userId);

    User findByName(String name);
}

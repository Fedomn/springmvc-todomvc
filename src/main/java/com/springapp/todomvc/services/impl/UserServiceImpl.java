package com.springapp.todomvc.services.impl;

import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.repository.UserRepository;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void deleteById(String id) {
        userRepository.delete(id);
    }

    @Override
    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}

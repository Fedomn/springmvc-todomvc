package com.springapp.todomvc.services.impl;

import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.repository.UserRepository;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

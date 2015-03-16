package com.springapp.todomvc.services.impl;

import com.springapp.todomvc.repository.UserRepository;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(String s) {
        userRepository.save(s);
    }
}

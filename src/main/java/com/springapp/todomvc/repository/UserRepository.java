package com.springapp.todomvc.repository;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    public void save(String s) {
        System.out.println(s);
    }
}

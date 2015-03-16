package com.springapp.todomvc.domain;


import org.springframework.stereotype.Repository;

@Repository
public class User {
    public void say(String arg) {
        System.out.println("User : " + arg);
    }

}

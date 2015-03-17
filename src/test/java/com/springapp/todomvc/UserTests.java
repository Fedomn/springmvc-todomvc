package com.springapp.todomvc;


import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTests{

    @Resource
    private UserServiceImpl userService;


    @Test
    public void sayTest() {
        userService.save(new User("1", 2));
    }


}

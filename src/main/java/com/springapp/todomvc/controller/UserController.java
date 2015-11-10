package com.springapp.todomvc.controller;


import com.springapp.todomvc.domain.ToDo;
import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllUsers() {
        List<User> allUsers = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("allUsers", allUsers);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestParam("user_name") String user_name) {
        return userService.save(new User(user_name));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("user_id") String id) {
        userService.deleteById(id);
        return id;
    }


    @RequestMapping(value = "/{userName}/todos", method = RequestMethod.GET)
    private ModelAndView showUserToDos(@PathVariable("userName") String name){
        User user = userService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("userToDoList");
        List<ToDo> userToDoLists = user.getToDoList();
        modelAndView.addObject("userToDoList", userToDoLists);
        modelAndView.addObject("userId", user.getId());
        return modelAndView;
    }

}

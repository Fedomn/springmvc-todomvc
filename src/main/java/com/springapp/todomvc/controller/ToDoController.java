package com.springapp.todomvc.controller;


import com.springapp.todomvc.domain.ToDo;
import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.services.ToDoService;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllToDos() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<ToDo> allToDos = toDoService.findAllToDos();
        modelAndView.addObject("allToDos", allToDos);
        return modelAndView;
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    @ResponseBody
    public ToDo addToDo(@RequestParam("title") String title, @RequestParam("user_id") String userId) {
        User user = userService.findOne(userId);
        user.addToDo(new ToDo(title));
        userService.save(user);
        return toDoService.findByTitle(title);
    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteToDo(@RequestParam("id") String id) {
        toDoService.deleteById(id);
        return id;
    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    @ResponseBody
    public ToDo updateToDoStatus(@RequestBody final ToDo toDo) {
        toDoService.updateToDo(toDo);
        return toDo;
    }

}

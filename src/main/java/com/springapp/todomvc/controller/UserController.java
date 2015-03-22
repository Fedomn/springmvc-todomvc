package com.springapp.todomvc.controller;


import com.springapp.todomvc.domain.User;
import com.springapp.todomvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "hello");
        return "index";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public User add(@RequestParam("title") String title) {
        System.out.println("/user/add");
        return userService.save(new User(title, 123));
    }

}

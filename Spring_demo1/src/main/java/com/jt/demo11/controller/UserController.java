package com.jt.demo11.controller;

import com.jt.demo11.pojo.User;
import com.jt.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void addUser(){
        User user = new User();
        user.setId(101);
        user.setAge(2022);
        user.setName("虎虎");
        user.setSex("母");
        userService.addUser(user);
    }
}

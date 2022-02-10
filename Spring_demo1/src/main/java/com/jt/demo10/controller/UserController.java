package com.jt.demo10.controller;

import com.jt.demo10.pojo.User;
import com.jt.demo10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void addUser(){
        User user = new User();
        user.setId(101);
        user.setName("春节快乐");
        user.setAge(2022);
        user.setSex("男");
        userService.addUser(user);
    }
}

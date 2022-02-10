package com.jt.demoT.controller;

import com.jt.demoT.pojo.User;
import com.jt.demoT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired//根据类型匹配
    private UserService userService;

    public void addUser(){
        User user = new User();
        user.setAge(2022);
        user.setName("fufu");
        user.setId(11);
        user.setSex("公");
        userService.addUser(user);
    }
}

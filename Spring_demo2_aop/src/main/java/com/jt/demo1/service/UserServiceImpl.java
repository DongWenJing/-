package com.jt.demo1.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("用户新增数据成功");
    }
}

package com.jt.demo11.service;

import com.jt.demo11.mapper.UserMapper;
import com.jt.demo11.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}

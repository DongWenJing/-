package com.jt.demoT.service;

import com.jt.demoT.mapper.UserMapper;
import com.jt.demoT.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired//根据类型匹配
    private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}

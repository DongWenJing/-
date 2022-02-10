package com.jt.demo10.service;

import com.jt.demo10.mapper.UserMapper;
import com.jt.demo10.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//对象交给Spring容器管理 key:userServiceImpl value:对象
public class UserServiceImpl implements UserService{
    @Autowired//根据类型匹配
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {

        userMapper.addUser(user);
    }
}

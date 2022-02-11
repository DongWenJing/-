package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.PageResult;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> findAll();

    String login(User user);
}

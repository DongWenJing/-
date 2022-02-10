package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //为接口创建代理对象,交给Spring容器管理
public interface UserMapper2 {
    List<User> findUser(User user);

    void updateUser(User user);

    List<User> findUserChoose(User user);
}

package com.jt.demo10.mapper;

import com.jt.demo10.pojo.User;

import org.springframework.stereotype.Repository;

//@Component//将对象交给Spring容器管理,key:usermapperimpl
@Repository//修饰持久层的,将对象交给Spring容器管理,key:usermapperimpl
public class UserMapperImpl implements UserMapper{
    @Override
    public void addUser(User user) {
        System.out.println("完成用户的入库操作"+user.getName());
    }
}

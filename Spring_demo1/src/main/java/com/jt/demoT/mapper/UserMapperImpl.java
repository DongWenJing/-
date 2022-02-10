package com.jt.demoT.mapper;

import com.jt.demoT.pojo.User;
import org.springframework.stereotype.Repository;

@Repository//交给spring容器管理  key是:userMapperImpl
public class UserMapperImpl implements UserMapper{
    @Override
    public void addUser(User user) {
        System.out.println("完成用户的入库操作,操作人:"+user.getName());
    }
}

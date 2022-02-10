package com.jt.demo11.mapper;

import com.jt.demo11.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper{
    @Override
    public void addUser(User user) {
        System.out.println("完成用户的入库操作:"+user.getName());
        System.out.println(user.getAge()+"新年快乐");
    }
}

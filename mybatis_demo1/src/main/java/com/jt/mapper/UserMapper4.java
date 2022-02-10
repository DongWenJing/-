package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper4 {

    List<User> findAll();
}

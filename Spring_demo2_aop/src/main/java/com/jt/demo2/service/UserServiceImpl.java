package com.jt.demo2.service;

import com.jt.demo2.anno.TX;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @TX
    @Override
    public void addUser() {

        System.out.println("用户新增数据成功");

    }

    @Override
    @TX
    public String finName() {
        //int a = 1/0;
        System.out.println("我欲乘风归去~");
        return "又恐琼楼玉宇~";
    }
}

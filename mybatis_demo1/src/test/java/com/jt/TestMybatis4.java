package com.jt;

import com.jt.mapper.UserMapper4;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class TestMybatis4 {

    @Autowired
    private UserMapper4 userMapper;

    /**
     * 测试需求:检查结果集的字段和属性不对应时的状态
     */
    @Test
    public void testResult(){
     List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

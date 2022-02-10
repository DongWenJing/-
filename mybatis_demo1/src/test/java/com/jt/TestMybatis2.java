package com.jt;

import com.jt.mapper.UserMapper2;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatis2 {
    @Autowired
    private UserMapper2 userMapper;
    /**
     * 需求:根据对象中不为null的属性,查询数据
     *
     */
    @Test
    public void testFindUser(){
        User user = new User();
        user.setAge(3000).setSex("男");
    List<User> list =   userMapper.findUser(user);
        System.out.println(list);
    }

    /**
     * 业务说明:
     *      根据对象中不为null的属性进行更新操作,id当做唯一条件.
     * 需求:
     *      将id=5的用户的name改为御弟哥哥 年龄 18
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5).setName("御弟哥哥").setAge(18);//sex为null
        userMapper.updateUser(user);
        System.out.println("修改操作成功");
    }

    /**
     * 业务说明:
     *      根据对象中不为null的属性进行更新操作,id当做唯一条件.
     * 需求:
     *      将id=236的用户的name改为弟中弟 年龄 18
     */
    @Test
    public void testUpdate2(){
        User user = new User();
        user.setId(236).setAge(18).setName("弟中弟");
        userMapper.updateUser(user);
        System.out.println("改好了");

    }

    @Test
    public void testFindChoose(){
        User user = new User();
        user.setAge(18);
      List<User> list =  userMapper.findUserChoose(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
}

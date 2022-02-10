package com.jt;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 要求:
 *      1.测试注解的包路径必须在主启动类的同包及子包中
 *      2.该注解只能在测试方法中使用
 *      3.该注解的作用:启动spring容器
 *      可以从容器中注入任意对象!!!
 */
@SpringBootTest
public class TestMybatis {
    @Autowired  //按照类型注入
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(100).setName("元宵节").setAge(18).setSex("女");
        //写法1:不需要服务器返回值
       // userMapper.saveUser(user);
        //写法2:需要返回值,返回影响的行数
        int rows = userMapper.saveUser2(user);
        System.out.println("影响的行数"+rows);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(233).setName("清明节");
        userMapper.updateUserById(user);
    }
    //删除
    @Test
    public void testDelete(){
        String q = "清明节";
        userMapper.deleteUser1(q);
    }
    @Test
    public void testDelete2(){
        User user = new User();
        user.setName("小法");
        userMapper.deleteUser(user);
    }

    /**
     *
     */
    @Test
    public void testSelectById(){
        int a = 7;
        User user = userMapper.findUser(a);
        System.out.println(user);
    }
    /**
     * Mybatis map 查询
     * 需求:查询age>18 and age <100的用户
     * SQL:select * from demo_user age>18 and age<100
     * 难点:POJO对象无法传递多个同名属性!
     * 解决方案:如果遇到同名属性可以封装为map集合
     */
    @Test
    public void testSelectMap(){
        Map map = new HashMap();
        map.put("minAge",18);
        map.put("maxAge",100);
      List<User> list = userMapper.selectMap(map);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testUserById(){
        Integer minId = 10;
        Integer maxId = 100;
     List<User> list =  userMapper.findUserByMId(minId,maxId);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 业务需求:模糊查询名字中包含"君"字的数据
     * SQL:select * from demo_user where name like "%君%"
     */
    @Test
    public void findUserByLike(){
        String name = "君";
      List<User> list = userMapper.findUserByLike(name);
        for (User user : list) {
            System.out.println(user);
        }
    }
    //使用数组,in
    @Test
    public void testUserByIn(){
        Integer[] array = {1,3,4,5,6};
     List<User> list =  userMapper.findUserByIn(array);
        System.out.println(list);
    }
    //经验:基本类型没有方法,采用包装类型才可以获取数据
    @Test
    public void testUserByIn2(){
        Integer[] array = {1,3,4,5,6};
        List<Integer> list = Arrays.asList(array);
     List<User> list2 =   userMapper.findUserByIn2(list);
        for (User user : list2) {
            System.out.println(user);
        }
    }
    //集合操作-map
    @Test
    public void findUserByInMap(){
        Integer[] array = {1,2,5,3,32,2};
        Map map = new HashMap();
        map.put("ids",array);
       List<User> list = userMapper.findUserByInMap(map);
        System.out.println(list);
    }

}

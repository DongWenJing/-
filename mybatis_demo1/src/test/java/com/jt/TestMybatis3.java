package com.jt;

import com.jt.mapper.UserMapper3;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest //作用启动Spring容器,只能用在测试类中
public class TestMybatis3 {
    @Autowired
    private UserMapper3 userMapper;

    @Test //练习增
    public void testInsert(){
        User user = new User();
        user.setAge(18).setSex("女").setName("元宵节").setId(111);
       Integer rows = userMapper.saveUser(user);
        System.out.println("插入成功:"+rows+"行");
    }

    @Test //练习改
    public void testUpdate(){
        User user = new User();
        user.setName("春节").setId(235);
        userMapper.updateUserById(user);
    }

    @Test //练习查询:根据Id查询 id=3
          //总结: 如果结果唯一,使用pojo接收
          //     如果结果不唯一,使用list<pojo>集合接收对象
    public void testFindUserById(){
        Integer id =3;
      User user =  userMapper.findUserById(id);
        System.out.println(user);
    }

    @Test  //测试删除
    public void testDeleteById(){
        Integer id = 235;
     userMapper.deleteUserById(id);
    }

    /**mybatis map查询
     * 需求:查询 id>18 and age<100的用户
     * SQL:select * from demo_user where id>18 and age<100
     * 难点在于:pojo对象无法传递多个同名的属性
     * 解决方案:如果遇到同名属性可以封装为map集合
     */
    @Test
    public void testFindMap(){
        Map map = new HashMap();
        map.put("id",18);
        map.put("age",100);
     List<User> list = userMapper.findUserByMap(map);
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test //测试使用指定字段查询数据区分#和$号
    public void testFindByColumn(){
        String column = "age";
        int value = 18;
        Map map = new HashMap();
        map.put("column",column);
        map.put("value",value);
     List<User> list =  userMapper.findByColumn(map);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 说明:简化map集合操作
     */
    @Test
    public void testFindParam(){
        int minId = 10;
        int maxId = 100;
      List<User> list =  userMapper.findUserByMId(minId,maxId);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 查询name中以"唐"字开头的数据
     * sql:select * from demo_user where name like"唐%"
     */
    @Test
    public void findUserByLike(){
        String name = "王";
      List<User> list =  userMapper.findUserByLike(name);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 说明:mybatis如果遇到批量操作,则可以使用集合的类型
     * 案例,查询id=1,3,4,5,6的数据
     * sql:select * from demo_user where id in(1,3,4,5,6)
     * in的限定条件:如果海量数据(>500W)查询时就不要用in了,尽量使用主键查询
     */
    @Test
    public void findUserByIn(){
        Integer[] array = {1,3,4,5,6};
       List<User> list = userMapper.findUserByIn(array);
        for (User user : list) {
            System.out.println(user);
        }
    }
    //集合操作-map集合
    @Test
    public void findUserByInMap(){
        Integer[] array = {1,4,5,6,9};
        HashMap map = new HashMap();
        map.put("ids",array);
      List<User> list =  userMapper.findUserByInMap(map);
        for (User user : list) {
            System.out.println(user);
        }
    }
    /**
     * 需求根据对象中不为null的属性,查询数据
     * 业务说明:由于数据来源属于前端服务器,参数可以是任意数据
     * 但是要求后端能实现所有数据的查询,一个方法通用
     * 动态SQL
     */

    @Test
    public void testFindUser(){
        User user = new User();
        user.setAge(18);
      List<User> list = userMapper.findUser(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
}

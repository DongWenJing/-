package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper  //1.将接口交给Mybatis管理,之后将mybatis交给Spring管理
         //2.动态代理机制,为接口创建代理对象 Map<userMapper,代理对象>
         //3.接口和实现类,为什么只有接口没有实现类?  因为SQL需要写到映射文件中
public interface UserMapper {

    //指定接口方法 查询demo_user的全部数据
    List<User> findAll();

    int saveUser2(User user);

    void saveUser(User user);

    void updateUserById(User user);

    void deleteUser(User user);

    void deleteUser1(String name);

    User findUser(int a);

    List selectMap(Map map);

    List<User> findUserByMId(@Param("minId") Integer minId,
                             @Param("maxId") Integer maxId);

    List<User> findUserByLike(String name);

    List<User> findUserByIn(Integer[] array);

    List<User> findUserByIn2(List<Integer> list);

    List<User> findUserByInMap(Map map);
}

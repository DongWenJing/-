package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper //1.将接口交给mybatis管理,之后交给spring容器管理
        //2.动态代理机制,为接口创建代理对象,Map<userMapper,代理对象>
        //3.接口和实现类,为什么只有接口没有实现类? 因为SQL写到映射文件中
public interface UserMapper3 {
    Integer saveUser(User user);

    void updateUserById(User user);

    User findUserById(Integer id);

    void deleteUserById(Integer id);

    List<User> findUserByMap(Map map);

    List<User> findByColumn(Map map);

    List<User> findUserByMId(@Param("minId") int minId,@Param("maxId") int maxId);

    List<User> findUserByLike(String name);

    List<User> findUserByIn(Integer[] array);

    List<User> findUserByInMap(HashMap map);

    List<User> findUser(User user);
}

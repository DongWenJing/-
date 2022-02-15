package com.jt.mapper;
import com.jt.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
public interface UserMapper {

    List<User> findAll();
    @Select("select * from user where username=#{username} and password=#{password}")
    User findUserByUp(User user);


    //多值的用@Param封装
    List<User> findUserList(@Param("query") String query,
                            @Param("size")Integer size,
                            @Param("startNum") Integer startNum);

    Long findCount(String query);

    @Update("update user set status=#{status},updated=#{updated} where id=#{id}")
    void updateStatus(User user);



//    @Insert("insert into user value(varchar(40) username=#{username},varchar(40) password=#{password}," +
//            "varchar(40) phone=#{phone},varchar(40) email=#{email})")
    void addUser(User user);
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

   // @Update("update user set phone=#{phone},email=#{email},updated={updated} where id=#{id}")
    void updateUser(User user);
    @Delete("delete from user where id=#{id}")
    void deleteUserById(Integer id);
}

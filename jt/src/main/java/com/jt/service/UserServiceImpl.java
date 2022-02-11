package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 实现思路:
     *  1.根据用户名和密码(加密处理)查询数据库
     *  2.有数据:用户名和密码正确
     *    没有数据:用户名和密码错误
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        //1.将密码加密处理
        String password = user.getPassword();
        password =  DigestUtils.md5DigestAsHex(password.getBytes());

        user.setPassword(password);
        //2.查询数据库
        User userDB = userMapper.findUserByUp(user);
        if (userDB == null) {
            //用户名和密码不对,返回的token应该为空
            return null;
        }
        //说明:用户名和密码正确 返回秘钥token,要求秘钥唯一
        //UUID 内部hash散列函数,根据当前毫秒数进行散列,几乎可以保证不重复
        String token = UUID.randomUUID().toString();
        return token;
    }
}

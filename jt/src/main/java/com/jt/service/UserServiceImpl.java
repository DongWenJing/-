package com.jt.service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

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

    /**
     * 业务说明:需要分页查询
     * SQL:  一页十条
     *     select * from user limit 起始位置,查询条数
     * 第一页:
     *      select * from user limit 0,10   含头不含尾[0,10)
     * 第二页:
     *      select * from user limit 10,10
     * 第三页:
     *      select * from user limit 20,10
     * 第N页:
     *      select * from user limit (n-1)*10,10
     * @param pageResult
     * @return
     */
    @Override
    public PageResult findUserList(PageResult pageResult) {
        Integer size = pageResult.getPageSize();
        Integer startNum = (pageResult.getPageNum()-1) * size;
        String query = pageResult.getQuery();
        //查询分页结果
        List<User> userList=
                userMapper.findUserList( query, size, startNum);
        //查询总的记录数
        Long total = userMapper.findCount(query);
        //将分页数据,进行封装
        pageResult.setTotal(total).setRows(userList);

        return pageResult;
    }
    //更新操作.准备修改时间
    @Override
    @Transactional //如果程序出现运行时异常,则实现事务的回滚
    public void updateStatus(User user) {//有两个参数
        user.setUpdated(new Date());//给修改时间赋值
        userMapper.updateStatus(user);
    }

    /**
     * 业务思维:
     *      1.密码需要加密
     *      2.设定状态信息,默认值为true
     *      3.设定创建时间和修改时间
     *      4.注意事务的控制
     * @param user
     */
    @Override
    @Transactional //事务控制
    public void addUser(User user) {
        //获取创建时间
        user.setCreated(new Date());
        //对密码进行MD5加密
       String password =  user.getPassword();
       password =  DigestUtils.md5DigestAsHex(password.getBytes());
       user.setStatus(true);
       user.setPassword(password);

        //获取更新时间
        user.setUpdated(new Date());
        userMapper.addUser(user);
    }

    @Override
    @Transactional
    public User findUserById(Integer id) {

        return userMapper.findUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        user.setUpdated(new Date());
        userMapper.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }
}

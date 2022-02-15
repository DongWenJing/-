package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin    //前后端进行跨域操作
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){

        return userService.findAll();
    }

    /**
     * URL:/user/login
     * 参数:username,password
     * 类型:post
     * 返回值:SysResult(token)对象
     */
    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        String token = userService.login(user);
        //如果返回的是空返回失败
        //if (token == null || "".equals(token))
        if (!StringUtils.hasLength(token)) {
            return SysResult.fail();
        }
       return  SysResult.success(token);
    }
    /**
     * 业务说明:分页查询用户信息
     * URL:http:/localhost:8091/user/list?query=查询关键字&pageResult
     * 参数:?query=查询关键字&pageSize=10
     * 返回值:SysResult(PageResult)
     */
    @GetMapping("/list")
    public  SysResult findUserList(PageResult pageResult){//现在3个有值
        //业务层完成,查询总数和记录数的操作
        pageResult = userService.findUserList(pageResult);

        return SysResult.success(pageResult);//要返回的是五条数据都有值
    }

    /**
     * 业务说明:用户状态修改
     * URL:/user/status/{id}/{status}
     * 请求类型:PUT
     * 请求参数:用户ID/状态值数据
     */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(User user){
        userService.updateStatus(user);
        return SysResult.success();
    }
    /**
     * 业务说明:新增用户
     * URL:/user/addUser
     * 请求类型:PUT
     * 请求参数:整个form表单数据封装为js对象进行参数传递
     * 返回值:SysResult对象
     */
    @PutMapping("/addUser")
    public SysResult addUser( User user){
        userService.addUser(user);
        return SysResult.success();
    }
    /**
     * 业务说明:提供修改数据层数据
     * url:/user/{id}
     * 参数:id
     * 返回值:SysResult(user对象)
     */
    @GetMapping("/{id}")
    public SysResult findUserById(@PathVariable Integer id){
       User user = userService.findUserById(id);
        return SysResult.success(user);
    }

    /**
     * 业务说明:根据用户ID更新数据
     * URL:/user/updateUser
     * 请求类型:PUT
     * 请求参数:User对象结构  三个参数 json串
     * 返回值: SysResult对象
     */
    @PutMapping("/updateUser")
    public SysResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return SysResult.success();
    }

    /**
     * URL:/user/{id}
     *
     */
    @DeleteMapping("/{id}")
    public SysResult deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return SysResult.success();
    }

}

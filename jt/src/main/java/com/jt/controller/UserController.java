package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
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
}

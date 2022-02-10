package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin //解决跨域问题,允许所有的网址访问
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * URL:localhost:8090/user/findAll
     * 参数:无
     * 返回值结果:List<User>
     */
    @GetMapping("/findAll")
    public List<User> findAll(){
      return userService.findAll();
    }
    /**
     * URL:localhost:8090/user/deleteById
     * 参数:id
     * 返回值结果:不要
     */
    @GetMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id){  //利用@PathVariable注解,动态获取路径中的数据,要求名称必须匹配
        userService.deleteUserById(id);
    }

}

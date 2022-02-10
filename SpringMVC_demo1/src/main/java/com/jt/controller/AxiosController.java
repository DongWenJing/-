package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/axios")
@CrossOrigin //解决跨域问题 允许所有的网址访问
//@CrossOrigin(value="http://www.jt.com") //解决跨域问题 允许www.jt.com网址访问
public class AxiosController {

    @GetMapping("/findStr")
    public String getAxios(){
     return "芽儿咯";
    }

    @GetMapping("/getUserById")
    public String findUserById(Integer id){
     return "获取到的数据" + id;
    }

    //接受对象信息
    @GetMapping("/findUser")
    public User findUser(User user){
        return user;
    }
    //接受restFul数据
    //URL:http://localhost:8080/axios/result/200/tomcat/19
    //返回值:User对象
    @GetMapping("/result/{id}/{name}/{age}")
    public User result1(User user){
        return user;
    }

    /**
     * 编辑后端Controller
     * URL: /axios/saveUser
     * 参数:json串
     *      {"id": 100, "name": "tom猫", "age": 20}
     * @return   User
     * 难点:
     *      1.将JSON串转化为Java对象    @RequestBody
     *      2.将Java的对象转化为JSON串  @ResponseBody
     */
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return user;
    }
}

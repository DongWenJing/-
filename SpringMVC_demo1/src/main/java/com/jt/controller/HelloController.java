package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller   //SpringMVC 专门扫描的注解
public class HelloController {

    @RequestMapping("/hello") //负责用户的'请求路径'与'后台服务器'之间的映射关系
                                //如果请求不匹配则会报错404
    @ResponseBody //将服务器的返回值转化为JSON串.本质就是字符串
                 // 如果服务器返回的是String类型则按照本身返回
    public String hello(){

        return "你好,SpringMVC";
    }
    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setAge(101);
        user.setName("王老五");
        return user;
    }
}

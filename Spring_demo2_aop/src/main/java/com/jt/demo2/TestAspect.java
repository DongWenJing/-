package com.jt.demo2;

import com.jt.demo2.config.SpringConfig;
import com.jt.demo2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //看上去:像是目标对象  AOP:内部已经封装动态代理机制
        //实际上:已经被AOP封装是一个代理对象
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getClass());
        //代理机制:可以扩展方法
        //userService.addUser();
        userService.finName();

    }
}

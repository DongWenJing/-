package com.jt.demo1;

import com.jt.demo1.config.SpringConfig;
import com.jt.demo1.proxy.JDKdemo1;
import com.jt.demo1.service.UserService;
import com.jt.demo1.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTX2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl service = context.getBean(UserServiceImpl.class);
        UserService user =(UserService) JDKdemo1.getUser(service);
        user.addUser();
    }
}

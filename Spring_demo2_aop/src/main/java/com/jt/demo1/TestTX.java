package com.jt.demo1;

import com.jt.demo1.config.SpringConfig;
import com.jt.demo1.proxy.TimeProxy;
import com.jt.demo1.service.UserService;
import com.jt.demo1.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTX {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserServiceImpl target = context.getBean(UserServiceImpl.class);

        UserService time =(UserService) TimeProxy.getTime(target);

        time.addUser();

    }
}

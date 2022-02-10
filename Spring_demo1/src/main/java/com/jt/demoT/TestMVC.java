package com.jt.demoT;

import com.jt.demoT.config.SpringConfig;
import com.jt.demoT.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMVC {
    public static void main(String[] args) {
   ApplicationContext context   =  new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.addUser();
    }
}

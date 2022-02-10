package com.jt.demo10;

import com.jt.demo10.config.SpringConfig;
import com.jt.demo10.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMVC {
    /**
     * 1.熟练掌握IOC/DI原理
     * 2.代码结构的嵌套 了解参数传递的规则
     * 3.将原有的面向对象,进行了高级的抽象
     * */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.addUser();

    }
}

package com.jt.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User2 {
    public static void main(String[] args) {
        //1.获取容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2.从容器中获取对象
        Dog dog = context.getBean(Dog.class);
        //3.通过对象调用方法
        dog.hello();
    }
}

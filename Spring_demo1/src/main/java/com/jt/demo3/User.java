package com.jt.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//注解开发
public class User {
    public static void main(String[] args) {
        //创造容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//用的是字节码
        //从容器中获取对象
        Dog dog = context.getBean(Dog.class);
        //通过对象调用方法
        dog.hello();

    }
}

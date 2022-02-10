package com.jt.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    //IOC
    public static void main(String[] args) {
        //1.指定配置文件
        String resource ="spring.xml";
        //2.创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        //3.从容器中获取对象
        Dog dog = context.getBean(Dog.class);//用类型方便点
        //Dog dog1 = (Dog) context.getBean("dog");
        //4.调用对象的方法
        dog.hello();
        //dog1.hello();
    }
}

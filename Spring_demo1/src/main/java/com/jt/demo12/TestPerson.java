package com.jt.demo12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
    public static void main(String[] args) {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("spring.xml");
        Person bean = context.getBean(Person.class);
        bean.toGo();
        bean.sayHi();
    }
}

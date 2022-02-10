package com.jt.demoss;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestPp {

    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("spring_ss.xml");
        Person person = context.getBean(Person.class);
        person.say();
        person.getCar();
    }
}

package com.jt.demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDept {

    public static void main(String[] args) {

    ApplicationContext context =  new   AnnotationConfigApplicationContext(SpringConfig.class);

        Dept dept = context.getBean(Dept.class);
        
        dept.hello();

    }
}

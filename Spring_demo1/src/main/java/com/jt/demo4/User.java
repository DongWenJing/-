package com.jt.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User {
    //该测试类,测试单例和多例对象
    public static void main(String[] args) {
        //创建容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //从容器中获取对象
        Dog dog = context.getBean(Dog.class);
         context.getBean(Dog.class);
         context.getBean(Dog.class);
         context.getBean(Dog.class);
         context.getBean(Dog.class);
        //通过对象调用方法
        dog.hello();
    }
}

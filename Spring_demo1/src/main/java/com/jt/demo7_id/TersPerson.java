package com.jt.demo7_id;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TersPerson {
    public static void main(String[] args) {
        //创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_id.xml");
       // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_id.xml");
        //从容器中获取对象
        Person bean = context.getBean(Person.class);
        //调用业务方法
        bean.sayHi();
        bean.toGo();
      //  context.close();//关流操作
    }
}


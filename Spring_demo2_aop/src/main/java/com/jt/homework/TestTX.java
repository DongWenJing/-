package com.jt.homework;

import com.jt.homework.config.SpringConfig;
import com.jt.homework.service.DogService;
import com.jt.homework.service.DogServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTX {
    public static void main(String[] args) {
        //创建容器对象
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    //从容器中获取对象
        DogService dogService = context.getBean(DogService.class);
        dogService.eat();
    }
}

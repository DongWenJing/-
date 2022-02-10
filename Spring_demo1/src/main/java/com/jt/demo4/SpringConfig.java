package com.jt.demo4;

import org.springframework.context.annotation.*;

@Configuration//配置注解
@ComponentScan("com.jt.demo4")//包扫描
public class SpringConfig {

    @Bean//dog()方法是key,new Dog()是value
    //@Scope("singleton")默认的就是单例
    @Lazy//懒加载开启,只对单例模式生效,多例模式都是懒加载,lazy注解不能控制
    @Scope("prototype")//这个注解表示多例对象,不写就默认单例
    public Dog dog(){
        return new Dog();
    }
}

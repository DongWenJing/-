package com.jt.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration//配置注解
@ComponentScan("com.jt.demo4")//包扫描让spring注解生效
public class SpringConfig1 {



    @Scope("prototype")//多例模型,默认都是懒加载就不用使用@lazy注解了,单例需要
    @Bean
    public Dog dog(){
        return new Dog();
    }
}

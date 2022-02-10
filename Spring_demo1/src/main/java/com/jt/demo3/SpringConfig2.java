package com.jt.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jt.demo3")
public class SpringConfig2 {

    //将对象交由Bean管理,其中dog()是Map中的key值
    //new Dog()是Map中的value
    @Bean
    public Dog dog(){
        return new  Dog();
    }
}

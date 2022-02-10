package com.jt.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//表示配置类
@ComponentScan("com.jt.demo6")//包扫描
public class SoringConfig {

    //手动创建对象,交给spring容器管理
    @Bean
    public User user(){
        return  new User();

    }
}

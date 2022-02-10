package com.jt.homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.jt.homework")
@EnableAspectJAutoProxy
public class SpringConfig {

}

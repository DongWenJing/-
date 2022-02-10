package com.jt.demo2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.jt.demo2")
//表示强制使用CGlib代理
@EnableAspectJAutoProxy(proxyTargetClass = true) //让AOP有效
public class SpringConfig {
}

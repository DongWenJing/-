package com.jt.demo2.aop;
//本类用于学习AOP的切面之切入点表达式
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//AOP面向切面编程
//知识点铺垫:切面 = 动态代理+方法的扩展  后期被AOP API封装
@Component//将这个类交给Spring容器管理
@Aspect   //标识当前类是一个切面
public class TxAspect {

    //编码: 切面 = 切入点表达式 + 通知方法
    //切入点表达式:为谁创建代理对象
    //@Pointcut("bean(userServiceImpl)") //单个
   // @Pointcut("within(com.jt.demo2.service.*)") //多个
    //@Pointcut("execution(* com.jt.demo2.service..*.*(..))") //细粒度
    //如果创建自定义注解  元注解
    @Pointcut("@annotation(com.jt.demo2.anno.TX)")
    public void pointCut(){

    }
    //通知方法:对原有方法的扩展
    @Before("@annotation(com.jt.demo2.anno.TX)")
    public void  before(){
        System.out.println("AOP的入门案例");
    }
}

package com.jt.demo2.aop;
//本类用于学习AOP的切面之通知方法
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//AOP面向切面编程
//知识点铺垫:切面 = 动态代理+方法的扩展  后期被AOP API封装
//将这个类交给Spring容器管理
@Component
//标识当前类是一个切面
@Aspect
public class TxAspect2 {

    //编码: 切面 = 切入点表达式 + 通知方法
    @Pointcut("bean(userServiceImpl)")
    public void poinCut(){

    }
    @Before("poinCut()")
    public void before(JoinPoint joinPoint){
        //1.获取目标对象的类型
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //2.获取目标对象的名称
        Class targetName = joinPoint.getSignature().getDeclaringType();
        //3.获取目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        //4.获取参数数据
        Object[] args = joinPoint.getArgs();
        System.out.println("目标对象的类型:"+targetClass);
        System.out.println("目标对象的名称:"+targetName);
        System.out.println("目标方法的名称:"+methodName);
        System.out.println("参数名称:"+ Arrays.toString(args));
    }

    /**
     * 记录目标方法的返回值结果
     * returning:后置通知获取返回值的属性
     */
    @AfterReturning(value = "poinCut()",returning ="result" )
    public void afterReturning(Object result){
        System.out.println("方法的返回值:"+result);//目标方法执行之后
    }

    /**
     * 说明:如果程序执行抛出异常了,那么则可以由异常通知进行记录
     *      throwing:抛出异常的属性
     */
    @AfterThrowing(value = "poinCut()",throwing = "excption")
    public void afterThrowing(Exception excption){
        //excption.printStackTrace();//显示所有异常,但是比较耗内存
        System.out.println("异常消息:"+excption.getMessage());//目标方法抛异常时执行
    }


    @After("poinCut()")
    public void after(){
        System.out.println("最终通知!");//最终执行,无论是否有抛出异常
    }
    /**
     * 注意事项:环绕通知必须添加参数,并且必须放在第一位
     * 用法:如果有下一个通知,则执行下一个通知,如没有则执行目标方法
     * @return */
    @Around("poinCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        Object result = joinPoint.proceed();
        System.out.println("环绕通知结束");
        return result;
    }
}

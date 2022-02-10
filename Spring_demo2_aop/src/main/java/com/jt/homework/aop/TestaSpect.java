package com.jt.homework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestaSpect {
    @Pointcut("bean(dogServiceImpl)") //标记为切入点
    public  void  poinCut(){

    }
    @Pointcut("execution(* com.jt.homework.service..*.*(..))")
    public void poinCut1(){

    }
    @AfterThrowing(value = "poinCut1()",throwing = "exception") //异常通知
    public void afterThoring(Exception exception){

        System.out.println("出现异常:"+exception.getMessage());
    }

    @Around("poinCut()" )
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        Long startTime = System.currentTimeMillis();
        //记录目标对象class
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //记录目标对象的名称
        String targetName = joinPoint.getSignature().getDeclaringTypeName();
        //记录目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("目标对象class:"+targetClass);
        System.out.println("目标对象的名称:"+targetName);
        System.out.println("目标方法的名称:"+methodName);
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知完毕");
        Long endTime = System.currentTimeMillis();
        System.out.println("运行时间:"+(endTime-startTime)+"毫秒");
        return proceed;
    }
}

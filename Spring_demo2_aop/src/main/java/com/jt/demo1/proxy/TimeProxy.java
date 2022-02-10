package com.jt.demo1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeProxy {
    public  static Object getTime(Object target){
        //获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //获取接口数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //创建代理对象
       return  Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Long startTime = System.currentTimeMillis();
                System.out.println("事务开始");
                Object invoke = method.invoke(target, args);
                System.out.println("事务提交");
                Long endTime  = System.currentTimeMillis();
                System.out.println("耗时:"+(endTime-startTime)+"毫秒");
                return invoke;
            }
        });
    }
}

package com.jt.demo1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public  class JDKdemo1 {
    public static Object getUser(Object target){
        //1.获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //2.获取接口数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.创建代理对象
       return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("事务开始");
                Object invoke = method.invoke(target, args);
                System.out.println("事务结束啦");
                return invoke;
            }
        });
    }


}

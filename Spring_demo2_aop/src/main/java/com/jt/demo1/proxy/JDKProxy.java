package com.jt.demo1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//当前类是工具API,目的获取代理对象
public class JDKProxy {
    /**
     * 参数说明:
     * ClassLoader loader, 类加载器:将class加载到Java运行机制中
     * Class<?>[] interfaces, 被代理者的接口数组,Java可以多实现
     * InvocationHandler h 将代理对象扩展的方法写在处理器内
     * @param target
     * @return
     */
    public static Object getProxy(Object target){
        //1.获取目标对象的类加载器
        ClassLoader loader = target.getClass().getClassLoader();
        //2.获取接口数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.获取处理器对象
        InvocationHandler invocationHandler = getInvocationHandler(target);
        //创建代理对象
     return Proxy.newProxyInstance(loader, interfaces,getInvocationHandler(target));
    }

    public static InvocationHandler getInvocationHandler(Object target){
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("事务开始");
                //调用 让目标方法执行 target:目标对象!!!   其他都是固定的写法
             Object result =   method.invoke(target, args);
                System.out.println("事务提交");
                return result;
            }
        };
    }
}

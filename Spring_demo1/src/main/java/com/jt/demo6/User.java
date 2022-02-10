package com.jt.demo6;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*spring自动为该注解标识的类,通过反射实例化对象交给
  spring容器管理,类似于@Bean注解
    @Component/@Bean区别:
  1.@Component  spring容器通过反射自动创建对象
    @Bean是用户手动自己创建的
  2.@Component  标识类的
    @Bean       标识类中的方法的
  3.@Component  对象的Id的类名首字母小写
    @Bean        对象的Id是方法名
*/
@Component
public class User {
    //1.对象的创建
    public User(){
        System.out.println("用户的对象创建成功");
    }
    //2.进行初始化操作
    @PostConstruct//初始化的注解
    public void init(){
        System.out.println("为属性赋值");
    }
    //3.进行业务的调用  业务方法,用户手动调用
    public void hello(){
        System.out.println("我爱学Java~");
    }
    //4.销毁方法
    @PreDestroy
    public void destory(){
        System.out.println("调用销毁方法,释放资源!!!");
    }
}

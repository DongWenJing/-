package com.jt.demo6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoringConfig.class);
        User user = context.getBean(User.class);
        User user1 =(User) context.getBean("user");

        //调用业务方法
        user.hello();
        user1.hello();
        //如果需要执行销毁方法,则需要先关闭容器的对象
        //思想:销毁动作是敏感行为,特殊处理,实现类中有关闭的方法,接口中没有
        context.close();

    }
}

package com.jt.demo8_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 1.该类主要测试 注解的注入方式
 * 2.练习对象的嵌套关系
 * 3.注解的写法与xml写法的原理相同的,形式不同
 * */
@Component//把user交给spring容器管理  key:user  value:反射后的对象
public class User {//用户

    /**
     * 注解说明:
 *      1.@Autowired  自动注入
 *      规则:
 *          1.默认条件下,底层是使用set方法注入.按照类型匹配
 *          2.set方式注入也可以按照name名称进行匹配
 *          3.只要使用了这个注解,默认自动生成setxxx的方法
 *     实现原理:
 *          1.类型匹配 如果是接口,则自动匹配其实现类对象
 *          2.name名称匹配:根据spring中的key进行注入.
 *      2.@Qualifier
 *          必须和 @Autowired联用,
 *          并且需要指定value的名称,就是spring中的key
 *
 *      准则:一般情况下,Spring中都是单实现的
 **/
    @Autowired
    @Qualifier("pig")
    private Pet pet;

    public void hello(){
        pet.hello();
    }

}

package com.jt.demo2;

public class NewDog {
    /*1.该方法是通过 反射机制实例化对象!!!框架中的重点
    * 2.反射机制:
    *   Java中创建对象的常用方式,指定类型的路径
    *   之后通过该方法.newInstance()~= new Dog();
    * 3.精髓:为什么使用反射而不是new呢?
    *   因为:第三方通过反射实例化对象,可以实现解耦合
    *   一般多用于框架,因为框架不清楚用户到底需要啥,只有
    *   运行时才清楚用户到底需要深对象,扩展性更好
    * 4.反射必须要有无参构造方法,没有无参构造无法反射创对象
    * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Dog dog = (Dog) Class.forName("com.jt.demo2.Dog").newInstance();
        dog.hello();

    }
}

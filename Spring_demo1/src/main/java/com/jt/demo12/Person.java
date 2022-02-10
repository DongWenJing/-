package com.jt.demo12;

import org.springframework.stereotype.Component;


public class Person {
    //定义属性
    private Integer id;   //注入简单的数据int String
    private String name;
    //private Car car = new Car(); //耦合性高
    private Car car;    //spring容器为属性赋值.

    //为属性赋值,必须有set方法!!!!!!!
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public void sayHi(){
        System.out.println("你好:"+id+":"+name);
    }

    public void toGo(){
        car.go();
    }
}
package com.jt.demoss;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private Integer age;
    private String  name;
    private Car car;

    public Person(){
        System.out.println("person的无参构造");
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("person的全参构造");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void say(){
        System.out.println("你好我叫"+name+"今年"+age+"岁了");
    }
    public void getCar(){
        car.car1();
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

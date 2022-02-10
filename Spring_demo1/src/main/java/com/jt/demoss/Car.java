package com.jt.demoss;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name;
    private String color;

    public Car(){
        System.out.println("车车的无参构造");
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("车车的全参构造");
    }

    public void car1(){
        System.out.println("我的座驾是"+name+"颜色是"+color);
    }
}

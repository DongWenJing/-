package com.jt.demo7_id;

public class Car {
    private String name;
    private String color;

    public  void go(){
        System.out.println("上我的"+color+"的"+name+"带你去浪漫的土耳其~");
    }
    public Car(){
        System.out.println("无参构造方法");
    }
    public Car(String name,String color){
        this.name=name;
        this.color=color;
        System.out.println("全参构造方法");
    }
}

package com.jt.demo7_id;

public class Person {
    private int id;
    private String name;
    private Car car;

    public void sayHi(){
        System.out.println("你好呀"+id+name);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public void toGo(){
        car.go();
    }
}

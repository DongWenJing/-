package com.jt.demo10.pojo;

import java.io.Serializable;

public class User implements Serializable {

    //1.属性都是私有的,方法是公有的  构造方法/get/set方法/toString
    //2.要求对象序列化   作用:1.保证数据按照正确的格式输出!
    //                    2.在多线程条件下,共享数据,必须序列化
    //3.POJO的对象,一般都是用来实现数据传递的.
    private Integer id;
    private String  name;
    private Integer age;
    private String  sex;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

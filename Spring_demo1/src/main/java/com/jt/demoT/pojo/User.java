package com.jt.demoT.pojo;

import java.io.Serializable;
//要求对象序列化,目的是保证数据按照正确的格式输出!
//              在多线程条件下,共享数据必须序列化
public class User implements Serializable {
    private  Integer id ;
    private  String  name;
    private  Integer age;
    private  String  sex;

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

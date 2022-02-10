package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data  //提供了get/set/toString等方法
@Accessors(chain = true) //开启链式加载
@NoArgsConstructor //提供无参构造
@AllArgsConstructor //提供全参构造
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;


}

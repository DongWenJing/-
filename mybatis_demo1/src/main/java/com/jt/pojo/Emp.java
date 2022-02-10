package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class Emp implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Dept    dept;
}

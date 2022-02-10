package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Integer deptId;
    private String  deptName;
    //思考:如何表示一个部门下有多个员工
    private List<Emp>  emp;
}

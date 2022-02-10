package com.jt;

import com.jt.mapper.DeptMapper;
import com.jt.mapper.EmpMapper;
import com.jt.pojo.Dept;
import com.jt.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatis5 {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;

    //分清主对象,员工和部门一对一
    //list1 为练习
    @Test
    public void testOneToOne(){
       Emp emp = new Emp();
        emp.setName("春节");
     List<Emp> list1 =  empMapper.findEmp1(emp);
        List<Emp> list = empMapper.findEmp();
        System.out.println(list);
        System.out.println(list1);
    }
    @Test
    public void testOneToMore(){
      List<Dept> list = deptMapper.findAll();
        System.out.println(list);
    }
}

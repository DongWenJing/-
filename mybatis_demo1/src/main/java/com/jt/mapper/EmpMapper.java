package com.jt.mapper;

import com.jt.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> findEmp();

    List<Emp> findEmp1(Emp emp);
}

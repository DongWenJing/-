package com.jt;

import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author : DongWJ
 * @Date : 2022/2/16 14:29
 */
@SpringBootTest
public class TestMP {
    @Autowired
    private ItemMapper itemMapper;
    @Test
    public void test01(){
        //查询全部的数据不需要条件,
     List<Item> list = itemMapper.selectList(null);
        System.out.println(list);
    }
}

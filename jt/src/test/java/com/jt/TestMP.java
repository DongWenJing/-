package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
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
    public void test01() {
        //查询全部的数据不需要条件,
        List<Item> list = itemMapper.selectList(null);
        System.out.println(list);
    }

    /**
     * 1.测试新增入库操作
     * mybatisPlus 核心:以对象的方式操作数据库
     */
    @Test
    public void test02() {
        Item item = new Item();
        item.setTitle("商品标题信息")
                .setSellPoint("卖点信息")
                .setNum(100);
        itemMapper.insert(item);
    }

    /**
     * 3.查询id=1的数据
     */
    @Test
    public void test03() {
        System.out.println(itemMapper.selectById(1));
    }

    /**
     * 4.根据title/sellPoint查询数据
     * 查询title = "邱思⑦" and sellPoint="活好"
     * 核心:
     * 1.以对象的方式操作数据库
     * 2.根据对象中不为null的属性充当条件
     */
    @Test
    public void test04() {
        //对象的方式封装数据只能实现and拼接
        Item item = new Item();
        item.setTitle("邱思⑦")
                .setSellPoint("活好");
        //条件构造器:动态拼接where条件的
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>(item);
        List<Item> items = itemMapper.selectList(queryWrapper);
        System.out.println(items);
    }

    /**
     * 5.查询价格大于500,小于200000
     * 1.条件构造器的连接符:
     * 1.等号  eq
     * 2.大于 > gt
     * 3.小于 < lt
     * 4.大于等于 >= ge
     * 5.小于等于 <= le
     * 6.不等于 != ne
     * 2.条件间关联用法 默认使用and链接,
     * 如果使用or则写or方法
     */
    @Test
    public void test05() {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        //queryWrapper.gt("字段名","字段值");
        queryWrapper.gt("price", "500")
                //.or()
                .lt("price", "200000");
        List<Item> list = itemMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * 6.查询价格大于600的商品,按照价格降序
     * sql:select * from item where price>600 order by price desc
     */
    @Test
    public void test06() {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("price", 600)
                .orderByDesc("price");
        List<Item> list = itemMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * 7.查询title中包含"华为"的数据
     * SQL:select * from item where title like "华为%"
     * 知识点:
     * 1. 以xxx开头  "xxx%" 右侧 likeRight
     * 2. 以xxx结尾  "%xxx" 左侧 likeLeft
     * 3. 包含       "%xxx%" 包含  like
     */
    @Test
    public void test07() {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", "华为");
        List<Item> list = itemMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * 8.查询:id 为1,2,3,4的数据
     * sql:select * from item in (1,2,3,4)
     */
    @Test
    public void test08() {
        Integer[] ids = {1, 2, 3, 4};
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        List<Item> list1 = itemMapper.selectList(queryWrapper);
        //API2数组转为集合
        List<Integer> ids1 = Arrays.asList(ids);
        List<Item> list2 = itemMapper.selectBatchIds(ids1);
        System.out.println(list1);
    }

    /**
     * 9.需求:根据对象中不为null的数据查询数据库
     * 核心:动态SQL的拼接
     */
    @Test
    public void test09() {
        String title = "";
        String sellPoint = "工艺好";
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.hasLength(title),"title",title);
        queryWrapper.eq(StringUtils.hasLength(sellPoint),"sell_point",sellPoint);
        List<Item> list = itemMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    /**
     * 10.查询:只查询主键信息,
     * 适用场景:适用关联查询!!!
     */
    @Test
    public void test10() {
        List idList = itemMapper.selectObjs(null);
        System.out.println(idList);
    }
    /**
     * 11.更新操作
     */
    @Test
    public void test11(){
        Item item = new Item();
        item.setTitle("蓝牙耳机");
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title","耳机");
        //itemMapper.updateById(item);
        itemMapper.update(item,queryWrapper);
    }
    /**
     * 12.完成删除操作
     */
    @Test
    public void test12(){
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title","邱思⑦");
        itemMapper.delete(queryWrapper);
        //itemMapper.deleteById(14);
    }
}
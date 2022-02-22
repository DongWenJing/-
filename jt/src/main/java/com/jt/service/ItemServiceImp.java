package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 9:19
 */
@Service
public class ItemServiceImp implements ItemService{
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;
    /**
     * 1.获取满足条件的记录总数
     * 2.进行分页操作
     * 原则:
     *      1.手写SQL  业务层简单 SQL高效直观
     *      2.利用MP实现  业务层复杂,SQL简单几乎可以不写
     * sql:select * from item limit 开始位置,每页条数  limit只对MySQL数据有效
     * @param pageResult
     * @return
     */
    @Override
    public PageResult getItemList(PageResult pageResult) {

        //1.获取总记录数
        //条件构造器
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", pageResult.getQuery());
        //long total = itemMapper.selectCount(queryWrapper);

        //2.完成分页操作
        //2.1准备一个分页对象,MP基于初始化条件获取分页其他数据
        IPage<Item> page = new Page<>(pageResult.getPageNum(),
                                      pageResult.getPageSize());
       page = itemMapper.selectPage(page,queryWrapper);//专门分页的
        //2.2获取总数,获取记录数
        long total = page.getTotal();
        List<Item> list = page.getRecords();
        return pageResult.setTotal(total).setRows(list);
    }

    @Override
    @Transactional
    // update item set status=#{status},updated=#{updated} where id=#{id}
    public void updateItemStatus(Item item) {
        //根据对象中不为null的元素
        item.setUpdated(new Date());
        itemMapper.updateById(item);
//        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", item);
//        itemMapper.update(item, queryWrapper);
    }

    /**
     * 入库的维护:
     * 1.状态
     * 2.创建/修改时间
     * @param itemVO
     */
    @Override
    @Transactional
    public void saveItem(ItemVO itemVO) {
        Date date = new Date();
        Item item = itemVO.getItem();
        item.setStatus(true).setCreated(date).setUpdated(date);
        itemMapper.insert(item);

        //入库详情表  item.id = itemDesc.id
        ItemDesc itemDesc = itemVO.getItemDesc();
        itemDesc.setId(item.getId()).setCreated(date).setUpdated(date);
        itemDescMapper.insert(itemDesc);
    }

    /**
     * 1.删除商品信息
     * 2.删除商品详情
     * @param id
     */
    @Override
    public void deleteItemById(Integer id) {
        itemMapper.deleteById(id);
        itemDescMapper.deleteById(id);
    }

    //复写下分页查询操作
    public PageResult getItemList1(PageResult pageResult){
        //获取条件构造器
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",pageResult.getQuery());
        //2.分页操作
        //2.1准备一个分页的对象,MP基于初始化条件获取分页其他数据
        Page<Item> page = new Page<>(pageResult.getPageNum(), pageResult.getPageSize());
       page = itemMapper.selectPage(page, queryWrapper);
       //2.2获取记录总数
        long total = page.getTotal();
        List<Item> list = page.getRecords();
        return pageResult.setTotal(total).setRows(list);
    }
}

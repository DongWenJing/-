package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.Item;

/**
 * @Author : DongWJ
 * @Date : 2022/2/16 14:19
 */
//必须添加泛型,因为泛型对象与表关联
public interface ItemMapper extends BaseMapper<Item> {
}

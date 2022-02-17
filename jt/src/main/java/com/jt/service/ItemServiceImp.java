package com.jt.service;

import com.jt.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 9:19
 */
@Service
public class ItemServiceImp implements ItemService{
    @Autowired
    private ItemMapper itemMapper;
}

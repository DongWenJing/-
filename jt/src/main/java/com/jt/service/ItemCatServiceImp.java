package com.jt.service;

import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemCatServiceImp implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    @Transactional
    public List<ItemCat> findItemCatList() {
        return null;
    }
}

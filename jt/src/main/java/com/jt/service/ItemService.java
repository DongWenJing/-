package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 9:19
 */
public interface ItemService {
    PageResult getItemList(PageResult pageResult);

    void updateItemStatus(Item item);

    void saveItem(ItemVO itemVO);
}

package com.jt.mapper;

import com.jt.pojo.ItemCat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemCatMapper {

    @Select("select * from item_cat where parent_id=#{parentId}")
    List<ItemCat> findItemCatByParentId(Integer parentId);

    @Select("select * from item_cat ")
    List<ItemCat> findItemCatList();
    @Update("update item_cat set status=#{status} where id=#{id}")
    void updateStatus(ItemCat itemCat);

    void saveItemCat(ItemCat itemCat);

    void updateItemCat(ItemCat itemCat);
    @Delete("delete from item_cat where id=#{id}")
    void deleteItemCatById(Integer id);
    @Delete("delete from item_cat where id=#{id} or parent_id=#{id}")
    void deleteItemCatById2(Integer id);

    void deleteItemCatById3(Integer id);
}

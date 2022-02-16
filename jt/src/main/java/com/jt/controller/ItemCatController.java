package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 业务说明:实现商品的分类三级菜单分类,要求三层结构嵌套
     * URL:/itemCat/findItemCatList/{level}
     * 请求类型:get
     * 请求参数:{level}
     * 返回值:SysResult对象
     */
    @GetMapping("/findItemCatList/{level}")
    public SysResult findItemCatList(@PathVariable  Integer level){ //1-2-3

        List<ItemCat> list =  itemCatService.findItemCatList(level);

        return SysResult.success(list);
    }

    /**
     * 业务说明:修改商品的状态
     * 请求路径:/itemCat/status/{id}/{status}
     * 请求类型:put
     * 参数:{id},{status}
     * 返回值:SysResult对象
     */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(ItemCat itemCat){//单个参数使用@PathVariable,多个使用对象接收
        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }

    /**
     * 业务说明:商品分类的新增
     * 请求路径:/itemCat/saveItemCat
     * 请求类型:post
     * 参数:表单数据,name,parentID,level==js对象
     * 返回值:SysResult对象
     */
    @PostMapping("/saveItemCat")
    public SysResult saveItemCat(@RequestBody ItemCat itemCat){
        itemCatService.saveItemCat(itemCat);
        return  SysResult.success();
    }

    /**
     * 业务说明:商品分类的修改
     * 请求路径:/itemCat/updateItemCat
     * 请求类型:put
     * 请求参数:表单数据:item对象
     * 返回值:SysResult对象
     */
    @PutMapping("/updateItemCat")
    public SysResult updateItemCat(@RequestBody ItemCat itemCat){
        itemCatService.updateItemCat(itemCat);
        return SysResult.success();
    }
    /**
     * 业务说明:商品分类的删除
     * 细节:
     *      如果用户删除三级菜单,则直接删除三级
     *      如果用户删除二级菜单,则先删除三级再删除二级
     *      如果删除一级菜单,则删除所有
     * 请求路径: /itemCat/deleteItemCat
     * 请求类型: delete
     * 请求参数:id,level
     * 返回值:SysResult对象
     */
    @DeleteMapping("/deleteItemCat")
    public SysResult deleteItemCat( ItemCat itemCat){
        itemCatService.deleteItemCat(itemCat);
        return SysResult.success();
    }
}

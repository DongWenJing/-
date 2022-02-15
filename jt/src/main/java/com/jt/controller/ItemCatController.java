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
        List<ItemCat> list =  itemCatService.findItemCatList();
        return SysResult.success(list);
    }
}

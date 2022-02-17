package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.service.ItemService;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : DongWJ
 * @Date : 2022/2/17 9:20
 */
@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
   private ItemService itemService;

    /**
     * 业务需求:商品列表展现
     * URL: /item/getItemList?query=&pageNum=1&pageSize=10
     * 请求类型: get
     * post  put 才会用到@RequestBody注解
     * 请求参数: 使用pageResult对象接收
     * 返回值:SysResult对象
     */
    @GetMapping("/getItemList")
    public SysResult getItemList(PageResult pageResult){ //3条记录
     pageResult = itemService.getItemList(pageResult); //2条
       return SysResult.success(pageResult); //返回五条
    }
    /**
     * 业务需求:商品的状态修改
     * URL:/item/updateItemStatus
     * 请求类型:put
     * 参数:使用对象接受
     * 返回值:SysResult
     */
    @PutMapping("/updateItemStatus")
    public SysResult updateItemStatus(@RequestBody Item item){
        itemService.updateItemStatus(item);
        return  SysResult.success();
    }

    /**
     * 业务说明:完成商品的入库操作 item item_desc表
     * URL:http://localhost:8091/item/saveItem
     * 参数:ItemVO
     * 返回值:SysResult对象
     */
    @PostMapping("/saveItem")
    public SysResult saveItem(@RequestBody ItemVO itemVO){
        itemService.saveItem(itemVO);
        return SysResult.success();
    }

}

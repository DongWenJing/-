package com.jt.controller;

import com.jt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

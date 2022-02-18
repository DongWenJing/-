package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : DongWJ
 * @Date : 2022/2/18 15:35
 */
@RestController
@CrossOrigin
public class PortController {

    //动态获取端口号
    @Value("${server.port}")
    private Integer port;
    @GetMapping("/getPort")
    public  String getPort(){
        return "端口号"+port;
    }
}

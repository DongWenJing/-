package com.jt.demo8_anno;

import org.springframework.stereotype.Component;

@Component
public class Pig implements Pet {

    @Override
    public void hello() {
        System.out.println("我是小猪你佩奇吗?");
    }
}

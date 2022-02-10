package com.jt.demo8_anno;

import org.springframework.stereotype.Component;
//对象套对象
@Component//将该对象交给spring容器管理,key:tiger  value:tiger对象
public class Tiger implements Pet{
    @Override
    public void hello() {
        System.out.println("虎年吉祥~");
    }
}

package com.jt.demo9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//当spring容器启动的时候,加载指定的配置文件,将数据保存到容器中!!!
@PropertySource(value = "classpath:/dept.properties",encoding = "utf-8")
public class Dept {

    //取值方式:从spring容器中获取数据 ${pro中的key}
    @Value("${dept.id}")
    private  Integer id;
    @Value("${dept.name}")
    private String  name;

    // @Value("101")
    //private  Integer id;
    //@Value("财务部")
    //private String  name;

    public void hello(){
        System.out.println("获取数据"+id+name);
    }
}

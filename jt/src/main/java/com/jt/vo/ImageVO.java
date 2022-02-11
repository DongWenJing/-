package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //开启链式加载
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
    private String virtualPath; //动态变化的路径
    private String urlPath;  //网络地址
    private String fileName; //图片名称

}

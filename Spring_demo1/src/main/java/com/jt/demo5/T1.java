package com.jt.demo5;

import java.io.*;

public class T1 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String file = "D://ready//1.txt";
        BufferedReader buf;//声明对象
        InputStreamReader isr =new InputStreamReader(new FileInputStream(file),"UTF-8");
        buf = new BufferedReader(isr);

        try {
           String str= buf.readLine();//读取一行数据
            System.out.println("读取的内容为:"+str);
        }catch (Exception e){
            e.printStackTrace();//输出异常
        }

    }
}

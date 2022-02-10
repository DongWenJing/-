package com.jt.demo5;

import java.util.Arrays;

/**
 * 文档注释
 * */
public class T2 {
    public static void main(String[] args) {

        System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000");
        int [] a = {1,24,5,6,3,43};
        for (int i : a) {
            String a1 = String.valueOf(i);
            System.out.println(a1);
        }


    }
}

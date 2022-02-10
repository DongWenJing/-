package com.jt.demo5;

import java.io.*;

public class TestBuffreader {
    public static void main(String[] args) throws IOException {
        BufferedReader  buf = new BufferedReader(new FileReader("D://ready//1.txt"));
        String s = buf.readLine();
        System.out.println(s);
    }
}

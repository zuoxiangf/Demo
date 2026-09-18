package com.example.demo.demogennericsDemo;

import com.example.demo.GenericsDemo.Demo;

/**
 * ClassName: test
 * Package: com.example.demo.demogennericsDemo
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        Demo1<String> dm = new Demo1<>("12123");
        Demo1<Integer> dm2 = new Demo1<>(123);
        System.out.println(dm2.getVar());
        int length = dm.getVar().length();
        System.out.println(length);
        Demo3<String,Integer> dm33 = new Demo3<>("12123",1);

    }
}

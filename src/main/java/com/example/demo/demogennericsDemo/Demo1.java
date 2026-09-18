package com.example.demo.demogennericsDemo;

/**
 * ClassName: Demo1
 * Package: com.example.demo.demogennericsDemo
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class Demo1<T> {
    private T var;

    public Demo1(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}

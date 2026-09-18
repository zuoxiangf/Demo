package com.example.demo.demogennericsDemo;

/**
 * ClassName: Demo3
 * Package: com.example.demo.demogennericsDemo
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class Demo3 <K,V>{
    private K key;
    private V value;

    public Demo3(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

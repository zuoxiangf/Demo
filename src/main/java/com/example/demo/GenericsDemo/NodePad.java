package com.example.demo.GenericsDemo;

/**
 * ClassName: Demo2
 * Package: com.example.demo.GenericsDemo
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */


public class NodePad<K,V> {
    private K key;
    private V value;

    public NodePad(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public NodePad() {
    }

    public K getKey(){
        return this.key ;
    }
    public V getValue(){
        return this.value ;
    }
    public void setKey(K key){
        this.key = key ;
    }
    public void setValue(V value){
        this.value = value ;
    }

}

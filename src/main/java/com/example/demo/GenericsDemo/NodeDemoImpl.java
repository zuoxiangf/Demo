package com.example.demo.GenericsDemo;

/**
 * ClassName: NodeDemoImpl
 * Package: com.example.demo.GenericsDemo
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class NodeDemoImpl<T> implements NoteDemo<T> {
    private T var;             // 定义属性

    public NodeDemoImpl(T var) {
        this.setVar(var);
    }


    public void setVar(T var) {
        this.var = var;
    }



    @Override
    public T get() {
        return this.var;
    }
}

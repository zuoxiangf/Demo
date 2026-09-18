package com.example.demo.study.singleton;

/**
 * ClassName: Singletion
 * Package: com.example.demo.study.singleton
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class Singletion {

    private Singletion instance;

    private Singletion() {
    }

    public Singletion getInstance() {
        if (instance == null) {
            synchronized (Singletion.class) {
                if (instance == null) {
                    instance = new Singletion();
                }
            }
        }
        return instance;
    }


    public void display(){
        System.out.println("Hurray! I am create as a Singleton!");
    }

}

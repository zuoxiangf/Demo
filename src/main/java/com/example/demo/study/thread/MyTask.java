package com.example.demo.study.thread;

/**
 * ClassName: MyTask
 * Package: com.example.demo.study.thread
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class MyTask implements Runnable{
    private String name;
    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is running");
    }
}

package com.example.demo.study.thread;

/**
 * ClassName: Thread
 * Package: com.example.demo.study
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class MyThread extends Thread{

    public MyThread() {
        super();
    }
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程启动了");
    }
}

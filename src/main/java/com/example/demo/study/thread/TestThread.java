package com.example.demo.study.thread;

import com.example.demo.study.thread.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * ClassName: TestThread
 * Package: com.example.demo.study.thread
 * Description:
 * 创建线程的四种方式：
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 3.实现Callable接口
 * 4.使用线程池
 *
 *
 * @Author zxf
 * @Version 1.0
 */
public class TestThread {
    public static void main(String[] args) {
        //1.继承Thread类
//        demo1();
        //2.实现Runnable接口
//        demo2();
        //3.实现Callable接口
//        demo3();
        //4.使用线程池
//        demo4();

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("可用的 CPU 核心数（逻辑处理器）: " + cores);

        //合理设置线程池大小（CPU密集型 ≈ CPU核数，IO密集型 ≈ 核数 * 2）
        //什么是（CPU密集型 ，IO密集型 ）
        //CPU密集型任务，如加密解密，矩阵运算，图像处理等，CPU核数越少，任务执行速度越快
        //IO密集型任务，如数据库查询，网络请求，文件处理等，CPU核数越多，任务执行速度越快


    }

    private static void demo4() {
        //4.使用线程池
        //合理设置线程池大小（CPU密集型 ≈ CPU核数，IO密集型 ≈ 核数 * 2）
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> {
            System.out.println("Running in pool thread: " + Thread.currentThread().getName());
        });
        executor.shutdown();
    }

    private static void demo3() {
        //3.实现Callable接口
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();

        // 如果需要获取返回值
        try {
            String result = futureTask.get(); // 这会阻塞直到任务完成
            System.out.println("Callable返回结果: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void demo2() {
        MyTask myThread = new MyTask("MyTask1");
        MyTask myThread2 = new MyTask("MyTask2");
        new Thread(myThread).start();
        new Thread(myThread2).start();
    }

    public static void demo1(){

        MyThread myThread1 = new MyThread("MyThread1");
        MyThread myThread2 = new MyThread("MyThread2");
        myThread1.start();
        myThread2.start();
    }

}

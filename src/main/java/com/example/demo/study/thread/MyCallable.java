package com.example.demo.study.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 * ClassName: MyCallable
 * Package: com.example.demo.study.thread
 * Description:
 *
 * @Author zxf
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable线程启动了" + Thread.currentThread().getName());
        return LocalDateTime.now().toString();
    }
}

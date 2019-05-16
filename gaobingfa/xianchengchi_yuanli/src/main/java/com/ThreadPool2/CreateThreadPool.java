package com.ThreadPool2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: gaobingfa
 * @description: 模拟线程池工作
 * @author: Mr.huang
 * @create: 2019-05-15 21:55
 **/
public class CreateThreadPool {
    /**
     * @Description: 最大并发数=最大线程数+队列数
     * // Executors.newCachedThreadPool();
     * //提交一个任务到线程池中，线程池的处理流程如下：
     * //1、判断线程池里的核心线程是否都在执行任务，如果不是（核心线程空闲或者还有核心线程没有被创建）则创建一个新的工作线程来执行任务。如果核心线程都在执行任务，则进入下个流程。
     * //2、线程池判断工作队列是否已满，如果工作队列没有满，则将新提交的任务存储在这个工作队列里。如果工作队列满了，则进入下个流程。
     * //3、判断线程池里的线程是否都处于工作状态，如果没有，则创建一个新的工作线程来执行任务。如果已经满了，则交给饱和策略来处理这个任务。
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        //用ThreadPoolExecutor穿件线程池,参数含义:核心数,最大线程,存活数字,存活数字单位,创建一个队列,用new ArrayBlockingQueue<Runnable>
        //泛型为runnable
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 3, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
        for (int i = 0; i <= 6; i++) {
            TackThread t1 = new TackThread("任务" + i);
            //用线程池执行任务
            poolExecutor.execute(t1);
        }
        //关闭线程池
        poolExecutor.shutdown();
    }
}

class TackThread implements Runnable {
    private String name;

    public TackThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + name);
    }
}

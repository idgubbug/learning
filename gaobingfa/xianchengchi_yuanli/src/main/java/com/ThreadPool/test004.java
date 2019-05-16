package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: gaobingfa
 * @description: 单线程化的线程池
 * @author: Mr.huang
 * @create: 2019-05-15 21:51
 **/
public class test004 {
    /**
     * @Description: 只有一个线程在工作
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
                }
            });
        }
    }
}

package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: gaobingfa
 * @description: 控制并发的线程池
 * @author: Mr.huang
 * @create: 2019-05-15 21:45
 **/
public class test002 {
    /**
     * @Description: / 控制并发数的线程池, 控制线程数量
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }

            });
        }
    }
}

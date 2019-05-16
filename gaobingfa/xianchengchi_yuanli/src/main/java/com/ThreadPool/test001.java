package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: gaobingfa
 * @description: 有缓存的线程池
 * @author: Mr.huang
 * @create: 2019-05-15 21:31
 **/
public class test001 {
    /**
     * @Description: 用executors创建带缓存的连接池 ,
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        //建立连接池
        ExecutorService newCachedThreadPool =
                Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = 1;
            //在连接池中放入线程 放10
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //反馈
                    System.out.println(Thread.currentThread().getId() + ",i" + temp);
                }
            });
        }
    }
}

package com.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: gaobingfa
 * @description: 定时线程数
 * @author: Mr.huang
 * @create: 2019-05-15 21:48
 **/
public class test003 {
    /**
    * @Description:
    * @Param: [args]
    * @return: void
    * @Author: Mr.huang
    * @Date: 2019/5/15
    **/
    public static void main(String[] args) {
        //核心数为3个
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            service.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);

                }
                //定时3秒后执行
            }, 3, TimeUnit.SECONDS);
        }
    }
}

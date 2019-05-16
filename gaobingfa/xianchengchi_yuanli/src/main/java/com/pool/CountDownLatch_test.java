package com.pool;

import java.util.concurrent.CountDownLatch;

/**
 * @program: gaobingfa
 * @description: 并发包
 * @author: Mr.huang
 * @create: 2019-05-15 20:44
 **/
public class CountDownLatch_test {
    /**
     * @Description: countdownlatch, 并发包, 表示计数器, 计数器的数字表示线程的个数, 当线程都执行完毕
     * countDownLatch.await();//表示个数执行完毕,为0,在继续执行后面的代码
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();//计数器值每次减去1
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();
        countDownLatch.await();// 減去为0,恢复任务继续执行
        System.out.println("两个子线程执行完毕....");
        System.out.println("主线程继续执行.....");
        for (int i = 0; i < 10; i++) {
            System.out.println("main,i:" + i);
        }
    }
}

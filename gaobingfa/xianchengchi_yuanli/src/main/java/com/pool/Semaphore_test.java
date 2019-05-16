package com.pool;
/**
 * @program: gaobingfa
 * @description: 计数信号量
 * @author: Mr.huang
 * @create: 2019-05-15 21:01
 **/

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore是一种基于计数的信号量。它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池，我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。它的用法如下：
 * availablePermits函数用来获取当前可用的资源数量
 * wc.acquire(); //申请资源
 * wc.release();// 释放资源
 */
public class Semaphore_test extends Thread {
    private String name;
    private Semaphore wc;

    public Semaphore_test(String name, Semaphore wc) {
        this.name = name;
        this.wc = wc;
    }

    @Override
    public void run() {
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0) {
            System.out.println(name + "天助我也，终于有茅坑了.....");
        } else {
            System.out.println(name + "怎么没有茅坑了...");
        }
        try {
            // 申请资源
            wc.acquire();
        } catch (InterruptedException e) {

        }
        System.out.println(name + "终于上厕所啦.爽啊" + ",剩下厕所:" + wc.availablePermits());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(name + "厕所上完啦!");
        // 释放资源
        wc.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1000);
        for (int i = 1; i <= 100000; i++) {
            Semaphore_test test = new Semaphore_test("第" + i + "个人", semaphore);
            test.start();
        }
    }
}

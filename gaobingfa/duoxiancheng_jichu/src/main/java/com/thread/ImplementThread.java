package com.thread;

/**
 * @program: gaobingfa
 * @description: 实现runnable类的多线程
 * @author: Mr.huang
 * @create: 2019-05-15 16:21
 **/
class createThread implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
        }
    }
}

public class ImplementThread {
    /**
     * @Description: runnable类实现的多线程要传递接口, 且都是属于线程不安全
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        createThread thread = new createThread();
        Thread t1 = new Thread(thread);
        t1.start();
        Thread.sleep(100);
        for (int i = 0; i < 100; i++) {
            System.out.println("main_i = " + i);
        }
    }
}

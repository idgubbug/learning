package com.thread;

/**
 * @program: gaobingfa
 * @description: join()方法的使用
 * @author: Mr.huang
 * @create: 2019-05-15 16:49
 **/
public class JoinThread {
    //join()方法,是将本线程的cpu执行权交个其他线程使用,本线程进入休眠
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("main_i = " + i);
        }

    }
}

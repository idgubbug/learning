package com.thread;

/**
 * @program: gaobingfa
 * @description: 守护线程的学习
 * @author: Mr.huang
 * @create: 2019-05-15 16:29
 **/
public class DaemonThread {
    /**
     * @Description: .setDaemon(true)设置守护线程(thread..), 守护线程和主线程(main)是一同消亡的
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程...");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("我是主线程...");
        }
        System.out.println("执行完毕。。");
    }

}

package com.thread;

/**
 * @program: gaobingfa
 * @description: 匿名内部类的方式实现多线程
 * @author: Mr.huang
 * @create: 2019-05-15 16:25
 **/

public class StaticThread {
    /**
     * @Description: 匿名内部来的方式实现多线程
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                }
            }
        });
        thread.start();
        System.out.println(thread.getId());
        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            System.out.println("main_i = " + i);
        }
    }
}

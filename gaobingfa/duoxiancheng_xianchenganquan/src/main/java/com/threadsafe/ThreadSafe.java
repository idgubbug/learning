package com.threadsafe;

import javax.swing.plaf.TableHeaderUI;

/**
 * @program: gaobingfa
 * @description: 线程安全问题
 * @author: Mr.huang
 * @create: 2019-05-15 17:02
 **/
public class ThreadSafe implements Runnable {
    private static int count = 100;
    private static volatile boolean flag = true;

    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    private void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张票");
            count--;
        } else {
            flag = false;
        }
    }

    /**
     * @Description: 线程安全问题是:多个线程共享同一资源变量的时候做写的操作可能会发生线程冲突问题,也就是线程安全问题
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        ThreadSafe safe = new ThreadSafe();
        Thread t1 = new Thread(safe, "一号");
        Thread t2 = new Thread(safe, "二号");
        t1.start();
        t2.start();
    }
}

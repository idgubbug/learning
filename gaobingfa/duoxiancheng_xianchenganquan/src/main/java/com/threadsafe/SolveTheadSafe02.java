package com.threadsafe;

/**
 * @program: gaobingfa
 * @description: 解决安全问题
 * @author: Mr.huang
 * @create: 2019-05-15 17:23
 **/
public class SolveTheadSafe02 {
    private static int count = 100;
    private static boolean flag = true;

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

    /**
     * @Description: 解决线程安全, 要同步可能发生线程冲突的代码块
     * 一同步方法(同步函数) 二同步代码块 此为同步方法(synchronized作用在方法上,多线程时要和wait,notify一同使用)
     * 每一个对象都有一个原子锁,this可以用其他对象代替,本this为明锁,在本类中使用,不与其他类的this相同
     * @Param: []
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    private synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张票");
            count--;
        } else {
            flag = false;
        }

    }

    public static void main(String[] args) {
        SolveThreadSafe safe = new SolveThreadSafe();
        Thread t1 = new Thread(safe, "一号");
        Thread t2 = new Thread(safe, "二号");
        t1.start();
        t2.start();
    }
}

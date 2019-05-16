package com.lock.reentrantLock;

/**
 * @program: gaobingfa
 * @description: 重入锁机制
 * @author: Mr.huang
 * @create: 2019-05-15 22:42
 **/
public class reEnterlock implements Runnable {
    public synchronized void get() {
        System.out.println("name:" + Thread.currentThread().getName() + " get();");
        set();
    }

    public synchronized void set() {
        System.out.println("name:" + Thread.currentThread().getName() + " set();");
    }

    public void run() {
        get();
    }

    /**
     * @Description: 重入锁也是递归锁,指的是同一线程 外层函数获得锁之后 ，
     * 内层递归函数仍然有获取该锁的代码，但不受影响
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 22:43
     **/
    public static void main(String[] args) {
        reEnterlock ss = new reEnterlock();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}

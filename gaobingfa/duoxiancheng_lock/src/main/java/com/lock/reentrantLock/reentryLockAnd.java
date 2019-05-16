package com.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: gaobingfa
 * @description: 重入锁+手动锁
 * @author: Mr.huang
 * @create: 2019-05-15 22:45
 **/
public class reentryLockAnd extends Thread {
    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    private void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    /**
     * @Description: 手动锁lock和重入锁(锁中套锁, 外层函数获取锁, 相当于内存的锁也一同获取)
     * lock手动上锁和手动释放锁
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15 22:49
     **/
    public static void main(String[] args) {
        reentryLockAnd lock = new reentryLockAnd();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();
    }
}

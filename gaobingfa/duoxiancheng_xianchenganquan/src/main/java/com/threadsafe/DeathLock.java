package com.threadsafe;

/**
 * @program: gaobingfa
 * @description: 死锁原理
 * @author: Mr.huang
 * @create: 2019-05-15 17:29
 **/
public class DeathLock implements Runnable {
    private int count = 100;
    private Object o = new Object();
    private boolean flag = true;

    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (o) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sale();
                }
            }
        } else {
            while (count > 0) {
                sale();
            }
        }
    }

    /**
     * @Description: 死锁:同步中嵌套同步,导致锁无法释放,你拿我的锁我拿你的锁,造成不能释放锁
     * 至少有两个锁以上,同步代码块的锁和同步方法的锁,可以认为是两个不同的锁
     * @Param: []
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    private synchronized void sale() {
        synchronized (o) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "," + "出售第" + (100 - count + 1) + "票");
                count--;
            }
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        DeathLock lock = new DeathLock();
        Thread t1 = new Thread(lock, "一号");
        Thread t2 = new Thread(lock, "二号");
        t1.start();

        Thread.sleep(40);
        lock.flag = false;
        t2.start();

    }
}

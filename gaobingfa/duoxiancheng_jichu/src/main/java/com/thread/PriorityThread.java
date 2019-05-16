package com.thread;

/**
 * @program: gaobingfa
 * @description: 线程的优先级问题
 * @author: Mr.huang
 * @create: 2019-05-15 16:53
 **/
public class PriorityThread {
    /**
     * @Description: 线程优先级问题, setprrority  1--10数字越大优先级越高 默认5
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程_i = " + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("次线程_i = " + i);
                }
            }
        });
        t1.setPriority(1);
        t2.setPriority(2);
        t1.start();
        t2.start();
    }
}

package com.thread;

/**
 * @program: gaobingfa
 * @description: 继承thread的多线程
 * @author: Mr.huang
 * @create: 2019-05-15 16:16
 **/


class ThreadTest001 extends Thread {
    @Override
    /**
     * @Description: 继承Thread实现的多线程
     * @Param: []
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
    }
}

public class ExtendsThread {
    /**
     * @Description: 实现多线程, 不需要传递接口, 直接用.start方法调用多线程
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        ThreadTest001 test001 = new ThreadTest001();
        test001.start();
        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

}

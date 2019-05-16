package com.threadsafe;

/**
 * @program: gaobingfa
 * @description: volatile关键字, 对其他线程时候可见
 * @author: Mr.huang
 * @create: 2019-05-15 18:01
 **/
public class ThreadVolatileDemo extends Thread {
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("开始执行子线程");
        while (flag) {
//在等待
        }
        System.out.println("停止执行子线程");
    }

    public void setRuning(boolean flag) {
        this.flag = false;
    }

    /**
     * @Description: volatile修饰的变量能够及时的改变的变量刷新到主内存中
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo demo = new ThreadVolatileDemo();
        demo.start();
        Thread.sleep(1000);
        demo.setRuning(false);
        System.out.println("flag 已经设置成false");
        Thread.sleep(1000);
        System.out.println(demo.flag);
    }
}

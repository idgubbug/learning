package com.pool;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: gaobingfa
 * @description: 屏障
 * @author: Mr.huang
 * @create: 2019-05-15 20:55
 **/
public class CyclicBarrier_test extends Thread {
    private CyclicBarrier cyclicBarrier;

    //初始化
    public CyclicBarrier_test(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + ",正在写入数据");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("线程" + Thread.currentThread().getName() + ",写入数据成功.....");

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
        }
        System.out.println("所有线程执行完毕..........");
    }

    /**
     * @Description: cyclicbarrire表示在线程数集齐到一定数量的时候才去唤醒等待的线程
     * @Param: [args]
     * @return: void
     * @Author: Mr.huang
     * @Date: 2019/5/15
     **/
    public static void main(String[] args) {
        //集齐5个线程数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        //开始收集5个线程
        for (int i = 0; i < 5; i++) {
            CyclicBarrier_test barrierTest = new CyclicBarrier_test(cyclicBarrier);
            barrierTest.start();
        }
    }
}
